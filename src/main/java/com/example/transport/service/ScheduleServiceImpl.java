package com.example.transport.service;

import com.example.transport.domain.*;
import com.example.transport.repository.*;
import com.example.transport.utils.schedule.documentgenerator.WriterPdf;
import com.example.transport.utils.schedule.schedulereader.excel.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.*;

import java.time.LocalDate;
import java.util.*;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    //@Autowired
    //private ScheduleRepo scheduleRepo;
    @Autowired
    private JourneyStopRepo journeyStopRepo;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TransportRepo transportRepo;
    @Autowired
    private StopTransportRepo stopTransportRepo;
    @Autowired
    private JourneyRepo journeyRepo;
    @Autowired
    private LineRepo lineRepo;

    @Override
    public void saveDataFromFile(MultipartFile file){
        String tmpDir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpDir);
        Path path = write(file, Paths.get(tmpDir));
        ExcelReader excelReader = new ExcelReader(path.toFile());
        List<List<Journey>> journeyList = null;
        try{
            journeyList = excelReader.getJourney();
            Map<String, Person> per = excelReader.getEmployee();
            personRepository.saveAll(per.values());
            Map<String, Transport> transport = excelReader.getTransport();
            transportRepo.saveAll(transport.values());
            Map<String, StopTransport> stops = excelReader.getStops();
            stopTransportRepo.saveAll(stops.values());
         /// lineRepo.saveAll(excelReader.getLines());;

            for (int i = 0; i < journeyList.size(); i++) {
                List<Journey> journeys  = journeyList.get(i);
                journeyRepo.saveAll(journeys);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Schedule> getAllSchedule(){
        return null; //scheduleRepo.findAll();
    }
    @Override
    public void addNewSchedule(Schedule schedule){
       // scheduleRepo.save(schedule);
    }

    @Override
    public Schedule getScheduleById(int id){
     return  null;//  scheduleRepo.findById(id).orElseThrow(()-> new TransportException("Schedule with id " + id + " was not found"));
    }

    @Override
    public void updateSchedule(int id, Schedule schedule){
      /*  Schedule oldSchedule = scheduleRepo.getReferenceById(id);
        //oldSchedule.setId(schedule.getId());
        scheduleRepo.save(oldSchedule);

       */
    }
    /*public void deleteSchedule(int id){
       if(!scheduleRepo.existsById(id)){
           throw new TransportException("Schedule with id " + id + " not found");
       }
        scheduleRepo.deleteById(id);
    }*/


    @Override
    public void uploadService() {


    }

    //public Path getPdfSchedule(String personId, Integer month){
    @Override
    public Path getPdfSchedule(String personId){
        Person person = personRepository.getReferenceById(personId);
        List<Journey> testList = journeyStopRepo.findAllWorkDayById(personId);
        WriterPdf pdf = new WriterPdf("C:\\Users\\alexe\\Downloads\\Doc1.pdf");
        Path  path = pdf.getScheduleForPerson(person, testList);
        return  path;
    }
}


package com.example.transport.service;

import com.example.transport.domain.*;
import com.example.transport.repository.*;
import com.example.transport.shedule.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


@Service
public class ScheduleService {
   // @Autowired
   // private ScheduleRepo scheduleRepo;
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
            for (int i = 0; i < journeyList.size(); i++) {
                List<Journey> journeys  = journeyList.get(i);
                journeyRepo.saveAll(journeys);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Path write(MultipartFile file, Path dir) {
        Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }

    public List<Schedule> getAllSchedule(){
        return null; //scheduleRepo.findAll();
    }
    public void addNewSchedule(Schedule schedule){
       // scheduleRepo.save(schedule);
    }
    public Schedule getScheduleById(int id){
     return  null;//  scheduleRepo.findById(id).orElseThrow(()-> new TransportException("Schedule with id " + id + " was not found"));
    }
    public void updateSchedule(int id, Schedule schedule){
      /*  Schedule oldSchedule = scheduleRepo.getReferenceById(id);
        //oldSchedule.setId(schedule.getId());
        scheduleRepo.save(oldSchedule);

       */
    }
    public void deleteSchedule(int id){
       // scheduleRepo.deleteById(id);
    }


    public void uploadService() {


    }
}


package com.example.transport.service;

import com.example.transport.domain.*;
import com.example.transport.exception.TransportException;
import com.example.transport.myReaderExcel.XLSParser;
import com.example.transport.repository.JourneyStopRepo;
import com.example.transport.repository.PersonRepository;
import com.example.transport.repository.ScheduleRepo;
import com.example.transport.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private JourneyStopRepo journeyStopRepo;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TransportRepo transportRepo;


    public void saveDataFromFile(MultipartFile file){
        String tmpDir = System.getProperty("C:\\Users\\alexe\\Downloads\\Timetable.xls");
        System.out.println(tmpDir);
        Path path = write(file, Paths.get(tmpDir));
        XLSParser xlsParser = new XLSParser();

        Journey journey = null;
        try{
            journey = xlsParser.getJourney(path.toFile());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    if (journey != null) {
        List<JourneyStop> stops = journey.getJourneyStops();
        List<Transport> transports = new ArrayList<>();
        List<Person> per = new ArrayList<>();
        System.out.println(stops);
        journeyStopRepo.saveAll(stops);
        personRepository.saveAll(per);
        transportRepo.saveAll(transports);
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
        return scheduleRepo.findAll();
    }
    public void addNewSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }
    public Schedule getScheduleById(int id){
     return    scheduleRepo.findById(id).orElseThrow(()-> new TransportException("Schedule with id " + id + " was not found"));
    }
    public void updateSchedule(int id, Schedule schedule){
        Schedule oldSchedule = scheduleRepo.getReferenceById(id);
        //oldSchedule.setId(schedule.getId());
        scheduleRepo.save(oldSchedule);
    }
    public void deleteSchedule(int id){
        scheduleRepo.deleteById(id);
    }


    public void uploadService() {


    }
}


package com.example.transport.controllers;

import com.example.transport.domain.Schedule;
import com.example.transport.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadSingleFileExample1(MultipartFile file) {


        System.out.println("File " + file.getName());
        scheduleService.saveDataFromFile(file);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<Schedule>> getAllSchedule(){
     return  new ResponseEntity<>(scheduleService.getAllSchedule(),HttpStatus.OK);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable int id){
        return new ResponseEntity<>(scheduleService.getScheduleById(id),HttpStatus.OK);
    }

    @PostMapping("/schedules")
    public ResponseEntity<String> addNewSchedule(@RequestBody Schedule schedule){
        scheduleService.addNewSchedule(schedule);
        return new ResponseEntity<>("Schedule was added", HttpStatus.CREATED);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable int id, @RequestBody Schedule schedule){
        scheduleService.updateSchedule(id, schedule);
        return new ResponseEntity<>("Schedule was updated", HttpStatus.OK);
    }
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int id){
        //scheduleService.deleteSchedule(id);
        return new ResponseEntity<>("Schedule was deleted", HttpStatus.OK);
    }
}

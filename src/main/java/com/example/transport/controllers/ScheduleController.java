package com.example.transport.controllers;

import com.example.transport.domain.Schedule;
import com.example.transport.domain.StopTransport;
import com.example.transport.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/example1/upload/file",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadSingleFileExample1(MultipartFile file) {


        System.out.println("File " + file.getName());
        scheduleService.saveDataFromFile(file);
        return ResponseEntity.ok("Success");
    }
    @GetMapping("/schedules")
    public List<Schedule> getAllSchedule(){
     return    scheduleService.getAllSchedule();
    }
    @GetMapping("/schedules/{id}")
    public Schedule getScheduleById(@PathVariable int id){
        return scheduleService.getScheduleById(id);
    }

    @PostMapping("/schedules")
    public String addNewSchedule(@RequestBody Schedule schedule){
        scheduleService.addNewSchedule(schedule);
        return "Ok";
    }

    @PutMapping("/schedules/{id}")
    public String updateSchedule(@PathVariable int id, @RequestBody Schedule schedule){
        scheduleService.updateSchedule(id, schedule);
        return "Ok";
    }
    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable int id){
        scheduleService.deleteSchedule(id);
        return "Ok";
    }
}

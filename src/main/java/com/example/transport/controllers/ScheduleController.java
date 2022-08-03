package com.example.transport.controllers;

import com.example.transport.domain.Schedule;
import com.example.transport.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
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

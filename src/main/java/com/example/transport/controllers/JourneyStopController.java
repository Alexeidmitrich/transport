package com.example.transport.controllers;

import com.example.transport.domain.JourneyStop;
import com.example.transport.service.JourneyStopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JourneyStopController {
    @Autowired
    JourneyStopServiceImpl journeyStopService;

    @GetMapping("/journeyStop")
    public List<JourneyStop> getAllJourneyStop(){
        return journeyStopService.getAllJourney();
    }
    @GetMapping("JourneyStop/{id}")
    public JourneyStop getJourneyStopById(@PathVariable int id){
      return   journeyStopService.getJourneyById(id);
    }
    @PostMapping("/journeyStop")
    public String addNewJourneyStop(@RequestBody JourneyStop journeyStop){
        journeyStopService.addNewJourneyStop(journeyStop);
        return "Ok";
    }
    @PutMapping("/journeyStop/{id}")
    public String updateJourneyStop(@PathVariable int id, @RequestBody JourneyStop journeyStop){
        journeyStopService.updateJourneyStop(id, journeyStop);
        return "Ok";
    }
    @DeleteMapping("/journeyStop/{id}")
    public String updateJourneyStop(@PathVariable int id){
        journeyStopService.deleteJourneyStop(id);
        return "Ok";
    }
}

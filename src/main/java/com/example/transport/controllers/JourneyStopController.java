package com.example.transport.controllers;

import com.example.transport.domain.JourneyStop;
import com.example.transport.service.JourneyStopService;
import com.example.transport.service.JourneyStopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JourneyStopController {
    @Autowired
    private JourneyStopService journeyStopService;

    @GetMapping("/journeyStop")
    public ResponseEntity<List<JourneyStop>> getAllJourneyStop(){
        return new ResponseEntity<>(journeyStopService.getAllJourney(),HttpStatus.OK);
    }

    @GetMapping("JourneyStop/{id}")
    public ResponseEntity<JourneyStop> getJourneyStopById(@PathVariable int id){
      return new ResponseEntity<>(journeyStopService.getJourneyById(id), HttpStatus.OK);
    }

    @PostMapping("/journeyStop")
    public ResponseEntity<String> addNewJourneyStop(@RequestBody JourneyStop journeyStop){
        journeyStopService.addNewJourneyStop(journeyStop);
        return new ResponseEntity<>("JourneyStop was added", HttpStatus.CREATED);
    }

    @PutMapping("/journeyStop/{id}")
    public ResponseEntity<String> updateJourneyStop(@PathVariable int id, @RequestBody JourneyStop journeyStop){
        journeyStopService.updateJourneyStop(id, journeyStop);
        return new ResponseEntity<>("JourneyStop was updated",HttpStatus.OK);
    }

    @DeleteMapping("/journeyStop/{id}")
    public ResponseEntity <String> updateJourneyStop(@PathVariable int id){
        journeyStopService.deleteJourneyStop(id);
        return new ResponseEntity<>("JourneyStop was deleted", HttpStatus.OK);
    }
}

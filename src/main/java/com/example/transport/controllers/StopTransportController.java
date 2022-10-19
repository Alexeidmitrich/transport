package com.example.transport.controllers;

import com.example.transport.domain.StopTransport;
import com.example.transport.service.StopTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StopTransportController {
    @Autowired
    private StopTransportServiceImpl stopTransportService;

    @GetMapping("/stoptransport")
    public ResponseEntity<List<StopTransport>> getAllStopTransport() {
        return new ResponseEntity<>( stopTransportService.getAllStopTransport(), HttpStatus.OK);
    }
    @GetMapping("/stoptransport/{id}")
    public ResponseEntity<StopTransport> getStopTransportById(@PathVariable String id){
        return new ResponseEntity<>(stopTransportService.getStopTransportById(id),HttpStatus.OK);
    }

    @PostMapping("/stoptransport")
    public ResponseEntity<String> addNewStopTransport(@RequestBody StopTransport stopTransport){
        stopTransportService.addNewStopTransport(stopTransport);
        return new ResponseEntity<>("Stop was added", HttpStatus.CREATED);
    }

    @PutMapping("/stoptransport/{id}")
    public ResponseEntity<String> updateStopTransport(@PathVariable String id, @RequestBody StopTransport stopTransport){
        stopTransportService.updateStopTransport(id, stopTransport);
        return new ResponseEntity<>("Stop was updated", HttpStatus.OK);
    }

    @DeleteMapping("/stoptransport/{id}")
    public ResponseEntity<String> deleteStopTransport(@PathVariable String id){
        stopTransportService.deleteStopTransport(id);
        return new ResponseEntity<>("Stop was deleted", HttpStatus.OK);
    }

}
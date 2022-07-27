package com.example.transport.controllers;

import com.example.transport.domain.StopTransport;
import com.example.transport.service.StopTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StopTransportController {
    @Autowired
    private StopTransportService stopTransportService;

    @GetMapping("/stoptransport")
    public List<StopTransport> getAllStopTransport(){
     return    stopTransportService.getAllStopTransport();
    }
    @GetMapping("/stoptransport/{id}")
    public StopTransport getStopTransportById(@PathVariable int id){
        return    stopTransportService.getStopTransportById(id);
    }
    @PostMapping("/stoptransport")
    public String addNewStopTransport(@RequestBody StopTransport stopTransport){
        stopTransportService.addNewStopTransport(stopTransport);
        return "Ok";
    }
    @PutMapping("/stoptransport/{id}")
    public String updateStopTransport(@PathVariable int id, @RequestBody StopTransport stopTransport){
        stopTransportService.updateStopTransport(id, stopTransport);
        return "Ok";
    }
}

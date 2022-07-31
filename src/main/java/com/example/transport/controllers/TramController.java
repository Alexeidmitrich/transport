package com.example.transport.controllers;

import com.example.transport.domain.Tram;
import com.example.transport.service.TramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TramController {
    @Autowired
    private TramService tramService;

    @GetMapping("/trams")
    public List<Tram> getAllTram(){
        return tramService.getAllTram();
    }
    @PostMapping("/trams")
    public String addNewTram(@RequestBody Tram tram){
        tramService.addNewTram(tram);
        return "Ok";
    }
    @GetMapping("/trams/{id}")
    public Tram getTramsById(@PathVariable int id){
        return tramService.getTramById(id);
    }
    @PutMapping("/trams/{id}")
    public String updateTram(@PathVariable int id, @RequestBody Tram tram){
        tramService.updateTram(id, tram);
        return "Ok";
    }
    @DeleteMapping("/trams/{id}")
    public String deleteTram(@PathVariable int id){
        tramService.deleteTram(id);
        return "Ok";
    }
}


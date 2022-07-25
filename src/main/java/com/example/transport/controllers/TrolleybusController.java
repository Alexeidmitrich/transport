package com.example.transport.controllers;

import com.example.transport.domain.Trolleybus;
import com.example.transport.service.TrolleybusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrolleybusController {
    @Autowired
    private TrolleybusService trolleybusService;

    @GetMapping("/trolleybuses")
    public List<Trolleybus> getTrolleybus(){
        return trolleybusService.getAllTrolleybus();
    }
    @PostMapping("/trolleybuses")
    public String addNewTrolleybus(@RequestBody Trolleybus trolleybus){
        trolleybusService.addNewTrolleybus(trolleybus);
        return "Ok";
    }
    @GetMapping("/trolleybuses/{id}")
    public Trolleybus getTrolleybusesById(@PathVariable int id){
        return trolleybusService.getTrolleybusById(id);
    }
    @PutMapping("/trolleybuses/{id}")
    public String updateTrolleybus(@PathVariable int id, @RequestBody Trolleybus trolleybus){
        trolleybusService.updateTrolleybus(id, trolleybus);
        return "Ok";
    }
    @DeleteMapping("/trolleybuses/{id}")
    public String deleteTrolleybus(@PathVariable int id){
        trolleybusService.deleteTrolleybus(id);
        return "Ok";
    }
}

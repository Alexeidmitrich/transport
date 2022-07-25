package com.example.transport.controllers;

import com.example.transport.domain.RoutesLong;
import com.example.transport.service.RoutesLongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoutesLongController {
    @Autowired
    private RoutesLongService routesLongService;

    @GetMapping("/routesLong")
    public List<RoutesLong> getRoutesLong(){
        return routesLongService.getAllRoutesLong();
    }

    @PostMapping("/routesLong")
    public String addNewRoutesLong(@RequestBody RoutesLong routesLong){
        routesLongService.addNewRoutersLong(routesLong);
        return "Ok";
    }
    @GetMapping("/routesLong/{id}")
    public RoutesLong getRoutesLongById(@PathVariable int id){
        return routesLongService.getRoutesLongById(id);
    }
    @PutMapping("/routesLong/{id}")
    public String updateRoutesLong(@PathVariable int id, @RequestBody RoutesLong routesLong){
        routesLongService.updateRoutesLong(id, routesLong);
        return "Ok";
    }
    @DeleteMapping("/routesLong/{id}")
    public String deleteRoutes(@PathVariable int id){
        routesLongService.deleteRoutesLong(id);
        return "Ok";
    }
}


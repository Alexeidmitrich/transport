package com.example.transport.controllers;

import com.example.transport.domain.RoutesShot;
import com.example.transport.service.RoutesShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoutesShotController {
    @Autowired
    private RoutesShotService routesShotService;
    @GetMapping("/routesShot")
    public List<RoutesShot> getAllRoutesShot(){
        return routesShotService.getAllRoutesShot();
    }
    @GetMapping("/routesShot/{id}")
    public RoutesShot getRoutesShotById(@PathVariable int id){
        return routesShotService.getRoutesShotById(id);
    }
    @PostMapping("/routesShot")
    public String addNewRoutesShot(@RequestBody RoutesShot routesShot){
        routesShotService.addNewRoutersShot(routesShot);
        return "Ok";
    }
    @PutMapping("/routesShot/{id}")
    public String updateRoutesShot(@PathVariable int id, @RequestBody RoutesShot routesShot){
        routesShotService.updateRoutesShot(id, routesShot);
        return "Ok";
    }
    @DeleteMapping("/routesShot/{id}")
    public String deleteRoutesShot(@PathVariable int id){
        routesShotService.deleteRoutesShot(id);
        return "Ok";
    }
}

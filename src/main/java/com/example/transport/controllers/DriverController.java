package com.example.transport.controllers;

import com.example.transport.domain.Driver;
import com.example.transport.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<Driver> getDrivers(){
        return driverService.getAllDriver();
    }
    @PostMapping("/drivers")
    public String addNewDriver(@RequestBody Driver driver){
        driverService.addNewDriver(driver);
        return "Ok";
    }
    @GetMapping("/drivers/{id}")
    public Driver getDriversById(@PathVariable int id){
        return driverService.getDriverById(id);
    }
    @PutMapping("/drivers/{id}")
    public String updateDriver(@PathVariable int id, @RequestBody Driver driver){
        driverService.updateDiverById(id,driver);
        return "Ok";
    }
    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable int id){
        driverService.deleteDriver(id);
        return "Ok";
    }
}

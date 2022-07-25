package com.example.transport.service;

import com.example.transport.domain.Driver;
import com.example.transport.exception.PersonNotFoundException;
import com.example.transport.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverService {
    @Autowired
    private DriverRepo driverRepo;

    public List<Driver> getAllDriver(){
       return driverRepo.findAll();
    }
    public void addNewDriver(Driver driver){
        driverRepo.save(driver);
    }
    public Driver getDriverById(int id){
       return driverRepo.findById(id).orElseThrow(()->new PersonNotFoundException("Driver wiht id" + id + " was not found"));
    }
    public void updateDiverById(int id, Driver driver){
        Driver drive = driverRepo.getReferenceById(id);
        drive.setFirstname(driver.getFirstname());
        driverRepo.save(drive);
    }
    public void deleteDriver(int id){
        driverRepo.deleteById(id);
    }
}

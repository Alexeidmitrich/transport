package com.example.transport.Service;

import com.example.transport.Domain.Driver;
import com.example.transport.Repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepo driverRepo;

    List<Driver> getAllDriver(){
       return driverRepo.findAll();
    }
    public void addNewDriver(Driver driver){
        driverRepo.save(driver);
    }
    public Optional<Driver> getDriverById(int id){
       return driverRepo.findById(id);
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

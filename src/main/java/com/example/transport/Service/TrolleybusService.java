package com.example.transport.Service;

import com.example.transport.Domain.Trolleybus;
import com.example.transport.Repository.TrolleybusRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrolleybusService {
    @Autowired
    private TrolleybusRepo trolleybusRepo;

    public List<Trolleybus> getAllTrolleybus(){
        return trolleybusRepo.findAll();
    }
    public Optional<Trolleybus> getTrolleybusById(int id){
        return trolleybusRepo.findById(id);
    }
    public void updateTrolleybus(Trolleybus trolleybus, int id){
        Trolleybus oldTrolleybus = trolleybusRepo.getReferenceById(id);
        oldTrolleybus.setNumber(trolleybus.getNumber());
        trolleybusRepo.save(oldTrolleybus);
    }
    public void addNewTrolleybus(Trolleybus trolleybus){
        trolleybusRepo.save(trolleybus);
    }
}

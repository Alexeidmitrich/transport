package com.example.transport.service;

import com.example.transport.domain.Trolleybus;
import com.example.transport.exception.TransportException;
import com.example.transport.repository.TrolleybusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrolleybusService {
    @Autowired
    private TrolleybusRepo trolleybusRepo;

    public List<Trolleybus> getAllTrolleybus(){
        return trolleybusRepo.findAll();
    }
    public Trolleybus getTrolleybusById(int id){
        return trolleybusRepo.findById(id).orElseThrow(()->new TransportException("Transport with id " + id + " was not found"));
    }
    public void updateTrolleybus(int id, Trolleybus trolleybus){
        Trolleybus oldTrolleybus = trolleybusRepo.getReferenceById(id);
        oldTrolleybus.setNumber(trolleybus.getNumber());
        trolleybusRepo.save(oldTrolleybus);
    }
    public void addNewTrolleybus(Trolleybus trolleybus){
        trolleybusRepo.save(trolleybus);
    }
    public void deleteTrolleybus(int id){
        trolleybusRepo.deleteById(id);
    }
}

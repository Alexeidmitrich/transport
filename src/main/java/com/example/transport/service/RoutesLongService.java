package com.example.transport.service;

import com.example.transport.domain.RoutesLong;
import com.example.transport.exception.RoutesException;
import com.example.transport.repository.RoutesLongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoutesLongService {
    @Autowired
    private RoutesLongRepo routesLongRepo;

    public List<RoutesLong> getAllRoutesLong(){
        return routesLongRepo.findAll();
    }
    public void addNewRoutersLong(RoutesLong routesLong){
        routesLongRepo.save(routesLong);
    }
    public void updateRoutesLong(int id, RoutesLong routesLong){
        RoutesLong oldRoutesLong = routesLongRepo.getReferenceById(id);
        oldRoutesLong.setNumber(routesLong.getNumber());
        routesLongRepo.save(oldRoutesLong);
    }
    public RoutesLong getRoutesLongById(int id){
       return routesLongRepo.findById(id).orElseThrow(()->new RoutesException("Routes with number " + id + " was not found"));
    }
    public void deleteRoutesLong(int id){
        routesLongRepo.deleteById(id);
    }
}

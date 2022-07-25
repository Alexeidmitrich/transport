package com.example.transport.service;

import com.example.transport.domain.RoutesShot;
import com.example.transport.exception.RoutesException;
import com.example.transport.repository.RoutesShotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoutesShotService {
    @Autowired
    private RoutesShotRepo routesShotRepo;

    public List<RoutesShot> getAllRoutesShot(){
        return routesShotRepo.findAll();
    }
    public void addNewRoutersShot(RoutesShot routesShot){
        routesShotRepo.save(routesShot);
    }
    public void updateRoutesShot(int id, RoutesShot routesShot){
        RoutesShot oldRoutesShot = routesShotRepo.getReferenceById(id);
        oldRoutesShot.setNumber(routesShot.getNumber());
        routesShotRepo.save(oldRoutesShot);
    }
    public RoutesShot getRoutesShotById(int id){
        return routesShotRepo.findById(id).orElseThrow(()->new RoutesException("Routes with number " + id + " was not found"));
    }
    public void deleteRoutesShot(int id){
        routesShotRepo.deleteById(id);
    }
}


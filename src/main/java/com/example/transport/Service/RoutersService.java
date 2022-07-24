package com.example.transport.Service;

import com.example.transport.Domain.Routes;
import com.example.transport.Repository.RoutesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutersService {
    @Autowired
    private RoutesRepo routesRepo;

    public List<Routes> getAllRoutes(){
        return routesRepo.findAll();
    }
    public void addNewRouters(Routes routes){
        routesRepo.save(routes);
    }
    public void updateRoutes(Routes routes, int id){
        Routes oldRoutes = routesRepo.getReferenceById(id);
        oldRoutes.setNumber(routes.getNumber());
        routesRepo.save(oldRoutes);
    }
    public Optional<Routes> getRoutesById(int id){
       return routesRepo.findById(id);
    }
    public void deleteRoutes(int id){
        routesRepo.deleteById(id);
    }
}

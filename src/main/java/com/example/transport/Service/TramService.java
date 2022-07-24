package com.example.transport.Service;

import com.example.transport.Domain.Tram;
import com.example.transport.Repository.TramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TramService {
    @Autowired
    private TramRepo tramRepo;

    public List<Tram> getAllTram(){
        return tramRepo.findAll();
    }
    public Optional<Tram> getTramById(int id){
        return tramRepo.findById(id);
    }
    public void updateTram(Tram tram, int id){
        Tram oldTram = tramRepo.getReferenceById(id);
        oldTram.setNumber(tram.getNumber());
        tramRepo.save(oldTram);
    }
    public void addNewTram(Tram tram){
        tramRepo.save(tram);
    }
    public void deleteTram(int id){
        tramRepo.deleteById(id);
    }
}

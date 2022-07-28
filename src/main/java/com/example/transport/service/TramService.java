package com.example.transport.service;

import com.example.transport.domain.Tram;
import com.example.transport.exception.TransportException;
import com.example.transport.repository.TramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TramService {
    @Autowired
    private TramRepo tramRepo;

    public List<Tram> getAllTram(){
        return tramRepo.findAll();
    }
    public Tram getTramById(int id){
        return tramRepo.findById(id).orElseThrow(()->new TransportException("Transport with id " + id + " was not found"));
    }
    public void updateTram(int id,Tram tram ){
        Tram oldTram = tramRepo.getReferenceById(id);
        oldTram.setId(tram.getId());
        tramRepo.save(oldTram);
    }
    public void addNewTram(Tram tram){
        tramRepo.save(tram);
    }
    public void deleteTram(int id){
        tramRepo.deleteById(id);
    }
}

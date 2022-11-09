package com.example.transport.service;

import com.example.transport.domain.StopTransport;
import com.example.transport.exception.StopTransportNotFound;
import com.example.transport.repository.StopTransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopTransportServiceImpl implements StopTransportService {
    @Autowired
    private StopTransportRepo stopTransportRepo;

    @Override
    public List<StopTransport> getAllStopTransport(){
        return stopTransportRepo.findAll();
    }

    @Override
    public void addNewStopTransport(StopTransport stopTransport){
        stopTransportRepo.save(stopTransport);
    }

    @Override
    public void updateStopTransport(String id, StopTransport stopTransport) {
        StopTransport oldStopTransport = stopTransportRepo.getReferenceById(id);
        oldStopTransport.setId(stopTransport.getId());
        stopTransportRepo.save(oldStopTransport);
    }

    @Override
    public void deleteStopTransport(String id){
        if(!stopTransportRepo.existsById(id)) {
            throw new StopTransportNotFound("Stop transport with id " + id + " not found");

        }
        stopTransportRepo.deleteById(id);
    }

    @Override
    public StopTransport getStopTransportById(String id){
        return   stopTransportRepo.findById(id).orElseThrow(()-> new StopTransportNotFound("StopTransport with numberStop " + id + " was not found"));
    }
}

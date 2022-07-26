package com.example.transport.service;

import com.example.transport.domain.Transport;
import com.example.transport.exception.TransportException;
import com.example.transport.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl {
    @Autowired
    private TransportRepo transportRepo;

    public List<Transport> getAllTransport(){
        return transportRepo.findAll();
    }

    public void addNewTransport(Transport transport){
        transportRepo.save(transport);
    }

    public Transport getTransportById(int id){
        return transportRepo.findById(id).orElseThrow(()->new TransportException("Transport with id " + id + " was not found"));
    }

    public void updateTransport(int id, Transport transport) {
        Transport oldTransport = transportRepo.getReferenceById(id);
        oldTransport.setId(transport.getId());
        transportRepo.save(oldTransport);
    }

    public void deleteTransport(int id){
        if(transportRepo.existsById(id)){
            throw new TransportException("Transport with id " + id + " not found");
        }
        transportRepo.deleteById(id);
    }
}

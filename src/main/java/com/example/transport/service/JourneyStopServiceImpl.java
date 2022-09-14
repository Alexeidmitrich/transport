package com.example.transport.service;


import com.example.transport.domain.JourneyStop;
import com.example.transport.exception.TransportException;
import com.example.transport.repository.JourneyStopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneyStopServiceImpl {
    @Autowired
    private JourneyStopRepo journeyStopRepo;

    public List<JourneyStop> getAllJourney(){
        return journeyStopRepo.findAll();
    }
    public JourneyStop getJourneyById(int id){
        return journeyStopRepo.findById(id).orElseThrow(()-> new TransportException("JourneyStop with id " + id + " was not found"));
    }
    public void addNewJourneyStop(JourneyStop journeyStop){
        journeyStopRepo.save(journeyStop);
    }
    public void updateJourneyStop(int id, JourneyStop journeyStop){
        JourneyStop oldJourneyStop = journeyStopRepo.getReferenceById(id);
       // oldJourneyStop.setId(journeyStop.getId());
        journeyStopRepo.save(oldJourneyStop);
    }
    public void deleteJourneyStop(int id){
        journeyStopRepo.deleteById(id);
    }


}

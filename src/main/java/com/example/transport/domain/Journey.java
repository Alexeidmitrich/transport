package com.example.transport.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Journey {

    private String number;
    private String numberForPassengers;
    private List<JourneyStop> journeyStops = new ArrayList<>();
    private String data;


    public void addJourneyStop(JourneyStop stop){
        journeyStops.add(stop);
    }
}

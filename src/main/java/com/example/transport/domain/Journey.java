package com.example.transport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Journey {

    private String number;
    private String numberForPassengers;
    private List<JourneyStop> journeyStops = new ArrayList<>();
    private String data;


    public void addJourneyStop(JourneyStop stop){
        journeyStops.add(stop);
    }
}

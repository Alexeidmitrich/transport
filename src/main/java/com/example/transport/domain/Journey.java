package com.example.transport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;
    private String numberForPassengers;
    @OneToMany(mappedBy = "journey", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<JourneyStop> journeyStops = new ArrayList<>();
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "line_id_lines")
    private Line line;


    public void addJourneyStop(JourneyStop stop){
        journeyStops.add(stop);
    }
}

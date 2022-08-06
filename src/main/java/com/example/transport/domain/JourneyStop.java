package com.example.transport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JourneyStop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, name = "id_journey_stop")
    private int id;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    @ManyToOne
    @JoinColumn(name = "stop_transport_id")
    private StopTransport stopTransport;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;
    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;


    @ManyToOne
    @JoinColumn(name = "journey_id_lines")
    private Journey journey;


}

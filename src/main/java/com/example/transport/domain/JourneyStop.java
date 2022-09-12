package com.example.transport.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class JourneyStop {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;
    @ManyToOne
    @JoinColumn(name = "stop_id")
    private StopTransport stop;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Person driver;
    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Person inspector;

    private LocalTime time;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "journey_id")
    private Journey journey;
}

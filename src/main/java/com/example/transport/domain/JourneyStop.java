package com.example.transport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JourneyStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

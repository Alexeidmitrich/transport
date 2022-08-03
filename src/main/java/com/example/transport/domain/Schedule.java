package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "schedules")
public class Schedule {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalTime timeArrival;
    private LocalTime timeDeparture;


    public Schedule(LocalTime timeArrival, LocalTime timeDeparture) {
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
    }
    public Schedule() {
    }

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<StopTransport> stopTransports;

    @ManyToMany
    @JoinColumn(name = "id_trams")
    private Set<Tram> trams;

    @ManyToMany
    @JoinColumn(name = "id_trolleybuses")
    private Set<Trolleybus> trolleybuses;

    @ManyToMany
    @JoinColumn(name = "id_lines")
    private Set<Line> lines;

    @ManyToMany
    @JoinColumn(name = "id_drivers")
    private Set<Driver> drivers;

    @ManyToMany
    @JoinColumn(name = "id_inspectors")
    private Set<Inspector> inspectors;

    public LocalTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public LocalTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

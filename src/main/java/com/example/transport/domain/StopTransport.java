package com.example.transport.domain;


import javax.persistence.*;
import java.time.LocalTime;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "stoptransport")
public class StopTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numberStop")
    protected int numberStop;
    protected String name;
    protected LocalTime timeStop;


    public StopTransport(int numberStop, String name, LocalTime timeStop) {
        this.numberStop = numberStop;
        this.name = name;
        this.timeStop = timeStop;
    }

    public StopTransport() {
    }

    @ManyToOne
    @JoinColumn(name = "id_line")
    private Lines lines;

    public int getNumberStop() {
        return numberStop;
    }

    public void setNumberStop(int numberStop) {
        this.numberStop = numberStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(LocalTime timeStop) {
        this.timeStop = timeStop;
    }
}

package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "trams")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tram{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "number_tram", nullable = false)
    protected int number;

    @ManyToOne
    @JoinColumn(name = "type_transport")
    private Transport transport;

    public Tram(int number) {
        this.number = number;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "tram", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "tram", targetEntity = Inspector.class)
    private List<Inspector> inspectors = new ArrayList<>();

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Tram() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

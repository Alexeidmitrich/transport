package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_transport")
    protected int id;

    public Transport(int id) {
        this.id = id;
    }

    public Transport() {
    }
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Tram.class)
    private List<Tram> trams = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Trolleybus.class)
    private List<Trolleybus> Trolleybuses = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Inspector.class)
    private List<Inspector> inspectors = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

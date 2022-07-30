package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("1")
public class Tram extends Transport{
    public Tram(int id, String type) {
        super(id, type);
    }

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Transport transport;*/


    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "id", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();*/

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "", targetEntity = Tram.class)
    private List<Tram> trams = new ArrayList<>();*/


    public Tram() {
    }
}

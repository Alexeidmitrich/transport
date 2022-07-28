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
    @Column(name = "id_tram", nullable = false)
    protected int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Transport transport;

    public Tram(int id) {
        this.id = id;
    }

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "id", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();*/

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "", targetEntity = Tram.class)
    private List<Tram> trams = new ArrayList<>();*/


    public Tram() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

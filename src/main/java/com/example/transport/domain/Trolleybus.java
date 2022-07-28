package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trolleybuses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trolleybus{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_trolleybus")
    private int id;
    public Trolleybus(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Transport transport;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "id", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();*/

    public Trolleybus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

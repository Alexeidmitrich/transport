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
    @Column(nullable = false)
    protected int id;
    @Column(name = "type", nullable = false)
    protected String type;

    public Transport(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();*/

    public Transport() {
    }

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "transport", targetEntity = Inspector.class)
    private List<Inspector> inspectors = new ArrayList<>();*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

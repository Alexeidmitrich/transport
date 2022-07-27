package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inspectors")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Inspector extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inspector")
    protected int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "type_transport", nullable = false)
    private Transport transport;

    public Inspector(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Inspector(int id) {
        this.id = id;
    }

    public Inspector() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}

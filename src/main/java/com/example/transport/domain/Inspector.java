package com.example.transport.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "inspectors")
public class Inspector extends Person{

    public Inspector(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Inspector() {
    }

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;
}

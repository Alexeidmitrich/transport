package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "drivers")
public class Driver  extends Person{
    public Driver(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }
    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;

    public Driver() {
    }
}


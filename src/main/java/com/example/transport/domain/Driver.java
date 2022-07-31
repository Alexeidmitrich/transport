package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("1")
public class Driver extends Person {
    public Driver(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Driver() {
    }
    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;
}


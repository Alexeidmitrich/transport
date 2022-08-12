package com.example.transport.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "drivers")

public class Driver extends Person {

    public Driver() {
    }

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;

    @Override
    public String toString() {
        return "Driver{" +
                "transports=" + transports +
                ", id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


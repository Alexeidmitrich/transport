package com.example.transport.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "inspectors")
@Getter
@Setter

public class Inspector extends Person {

    public Inspector() {
    }

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;

    @Override
    public String toString() {
        return "Inspector{" +
                "transports=" + transports +
                ", id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

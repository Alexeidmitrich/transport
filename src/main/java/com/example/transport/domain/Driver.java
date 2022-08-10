package com.example.transport.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "drivers")
@Data
public class Driver  extends Person{

    public Driver() {
    }
    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;
}


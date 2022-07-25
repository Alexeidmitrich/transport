package com.example.transport.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "trams")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tram extends Transport{
    public Tram(int number) {
        super(number);
    }

    public Tram() {
    }
}

package com.example.transport.Domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "trolleybuses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trolleybus extends Transport{
    public Trolleybus(int number) {
        super(number);
    }

    public Trolleybus() {
    }
}

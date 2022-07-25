package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "drivers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Driver extends Person{
    public Driver(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Driver() {
    }
}

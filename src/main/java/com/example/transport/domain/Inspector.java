package com.example.transport.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "inspectors")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Inspector extends Person{

    public Inspector(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Inspector() {

    }
}

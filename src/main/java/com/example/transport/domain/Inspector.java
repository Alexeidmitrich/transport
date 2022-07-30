package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("2")
public class Inspector extends Person{

    public Inspector(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Inspector() {

    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private Transport transport;
}

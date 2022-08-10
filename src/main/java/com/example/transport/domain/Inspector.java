package com.example.transport.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "inspectors")
@Data
public class Inspector extends Person{

    public Inspector() {
    }

    @ManyToMany
    @JoinColumn(name = "id")
    private Set<Transport> transports;
}

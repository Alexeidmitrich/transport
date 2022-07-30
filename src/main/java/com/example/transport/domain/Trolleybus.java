package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class Trolleybus extends Transport{


    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Transport transport;*/

    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "id", targetEntity = Driver.class)
    private List<Driver> drivers = new ArrayList<>();*/

    public Trolleybus() {
    }

}

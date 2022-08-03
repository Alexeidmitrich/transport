package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@DiscriminatorValue("tram")
public class Tram extends Transport{
    public Tram(int id) {
        super(id);
    }


    public Tram() {
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}

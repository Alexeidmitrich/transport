package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("trolleybus")
public class Trolleybus extends Transport{
    public Trolleybus(int id) {
            super(id);
    }

    public Trolleybus() {
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

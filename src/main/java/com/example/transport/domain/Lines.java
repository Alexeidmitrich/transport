package com.example.transport.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class Lines {
    protected int number;

    public Lines(int number) {
        this.number = number;
    }

    public Lines() {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "number_RoutesLong", targetEntity = RoutesLong.class)
    private List<RoutesLong> routesLongList;
}

package com.example.transport.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transport {
    @Id
    @Column(name = "number", nullable = false)
    protected int number;

    public Transport(int number) {
        this.number = number;
    }

    public Transport() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

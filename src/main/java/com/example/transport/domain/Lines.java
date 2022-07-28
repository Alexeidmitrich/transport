package com.example.transport.domain;

import javax.persistence.*;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "lines")
public class Lines {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,name = "id_lines")
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
}

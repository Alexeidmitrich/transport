package com.example.transport.domain;

import javax.persistence.*;

@Entity
@Table(name = "trolleybuses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trolleybus extends Transport{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "number_trolleybus", nullable = false)
    protected int number;

    public Trolleybus() {
    }
    @ManyToOne
    @JoinColumn(name = "type_transport")
    private Transport transport;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

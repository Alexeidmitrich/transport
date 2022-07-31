package com.example.transport.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    protected int number;

    public Line(int number) {
        this.number = number;
    }

    public Line() {
    }
    /*@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "lines", targetEntity = StopTransport.class)
    private List<StopTransport> stopTransports = new ArrayList<>();*/

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "city_lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, name = "id_lines")
    private int number;

    public Line(int number) {
        this.number = number;
    }

    public Line() {
    }
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "line", targetEntity = StopTransport.class)
    private List<StopTransport> stopTransports = new ArrayList<>();

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

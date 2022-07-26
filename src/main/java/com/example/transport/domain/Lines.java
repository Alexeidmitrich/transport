package com.example.transport.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "lines")
public class Lines{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lines")
    protected int id;

    public Lines(int id) {
        this.id = id;
    }
    public Lines() {
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "numberStop", targetEntity = StopTransport.class)
    protected List<StopTransport> stopTransport = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

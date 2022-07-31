package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "stoptransport")
public class StopTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "access", nullable = false)
    private String access;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lines")
    private Line line;

    public StopTransport(int id, String name, LocalTime time, String access) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.access = access;
    }

    public StopTransport() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}

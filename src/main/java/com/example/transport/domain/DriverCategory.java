package com.example.transport.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "driver_category")
public class DriverCategory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String category;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id", nullable = false)
    private Set<Driver> drivers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DriverCategory() {
    }

}

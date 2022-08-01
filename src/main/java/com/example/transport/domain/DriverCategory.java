package com.example.transport.domain;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "driver_category")
public class DriverCategory {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String categoryTram;
    private String categoryTrolleybus;
    private String categoryBus;
    private String empty1;
    private String empty2;
    private String empty3;
    private String empty4;
    private String empty5;

    public DriverCategory(String categoryTram, String categoryTrolleybus, String categoryBus, String empty1, String empty2, String empty3, String empty4, String empty5, Driver driver) {
        this.categoryTram = categoryTram;
        this.categoryTrolleybus = categoryTrolleybus;
        this.categoryBus = categoryBus;
        this.empty1 = empty1;
        this.empty2 = empty2;
        this.empty3 = empty3;
        this.empty4 = empty4;
        this.empty5 = empty5;
        this.driver = driver;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "driver", nullable = false)
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DriverCategory() {
    }

    public String getCategoryTram() {
        return categoryTram;
    }

    public void setCategoryTram(String categoryTram) {
        this.categoryTram = categoryTram;
    }

    public String getCategoryTrolleybus() {
        return categoryTrolleybus;
    }

    public void setCategoryTrolleybus(String categoryTrolleybus) {
        this.categoryTrolleybus = categoryTrolleybus;
    }

    public String getCategoryBus() {
        return categoryBus;
    }

    public void setCategoryBus(String categoryBus) {
        this.categoryBus = categoryBus;
    }

    public String getEmpty1() {
        return empty1;
    }

    public void setEmpty1(String empty1) {
        this.empty1 = empty1;
    }

    public String getEmpty2() {
        return empty2;
    }

    public void setEmpty2(String empty2) {
        this.empty2 = empty2;
    }

    public String getEmpty3() {
        return empty3;
    }

    public void setEmpty3(String empty3) {
        this.empty3 = empty3;
    }

    public String getEmpty4() {
        return empty4;
    }

    public void setEmpty4(String empty4) {
        this.empty4 = empty4;
    }

    public String getEmpty5() {
        return empty5;
    }

    public void setEmpty5(String empty5) {
        this.empty5 = empty5;
    }
}

package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "drivers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Driver extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_driver")
    protected int id;

    @ManyToOne
    @JoinColumn(name = "tram_number_tram")
    private Tram tram;

    public Driver(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        super(firstname, lastname, date, phone, email, address);
    }

    public Driver(int id) {
        this.id = id;
    }
    public Driver() {
    }
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "type_transport", nullable = false)
    private Transport transport;

    public Tram getTram() {
        return tram;
    }

    public void setTram(Tram tram) {
        this.tram = tram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

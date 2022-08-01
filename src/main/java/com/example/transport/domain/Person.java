package com.example.transport.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "employee",discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private int id;
   @Column(nullable = false, length = 55)
   private String firstname;
   @Column(nullable = false,length = 55)
   private String lastname;
   @Column(nullable = false,length = 8)
   private LocalDate date;
   @Column(nullable = false,length = 16)
   private String phone;
   @Column(nullable = false, length = 55)
   private String email;
   @Column(nullable = false, length = 100)
   private String address;

    public Person(int id, String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Person(String firstname, String lastname, LocalDate date, String phone, String email, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

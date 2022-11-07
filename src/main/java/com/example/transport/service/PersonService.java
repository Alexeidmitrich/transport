package com.example.transport.service;

import com.example.transport.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    Person getPersonById(String id);
}

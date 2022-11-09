package com.example.transport.service;

import com.example.transport.domain.Person;
import com.example.transport.exception.PersonNotFoundException;
import com.example.transport.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }


    @Override
    public Person getPersonById(String id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " is not exists"));
    }
}

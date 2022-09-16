package com.example.transport.service;

import com.example.transport.domain.Person;
import com.example.transport.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(String id) {
        return personRepository.findById(id).get();
    }
}

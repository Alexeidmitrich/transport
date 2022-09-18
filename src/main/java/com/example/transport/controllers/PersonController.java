package com.example.transport.controllers;

import com.example.transport.domain.Person;
import com.example.transport.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.getPersonById(id);
    }
}

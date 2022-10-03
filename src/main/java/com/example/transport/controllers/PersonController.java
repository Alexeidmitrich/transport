package com.example.transport.controllers;

import com.example.transport.domain.Person;
import com.example.transport.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
}

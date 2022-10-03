package com.example.transport.controllers;

import com.example.transport.domain.Transport;
import com.example.transport.service.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportController {
    @Autowired
    private TransportServiceImpl transportService;

    @GetMapping("/transport")
    public ResponseEntity<List<Transport>> getAllTransport(){
        return new ResponseEntity<>(transportService.getAllTransport(), HttpStatus.OK);
    }

    @GetMapping("/transport/{id}")
    public ResponseEntity<Transport> getTransportById(@PathVariable int id){
        return new ResponseEntity<>(transportService.getTransportById(id),HttpStatus.OK);
    }

    @PostMapping("/transport")
    public ResponseEntity<String> addNewTransport(@RequestBody Transport transport){
        transportService.addNewTransport(transport);
        return new ResponseEntity<>("Transport was added", HttpStatus.CREATED);
    }

    @PutMapping("/transport/{id}")
    public ResponseEntity<String> updateTransport(@PathVariable int id, @RequestBody Transport transport){
        transportService.updateTransport(id, transport);
        return new ResponseEntity<>("Transport was updated", HttpStatus.OK);
    }

    @DeleteMapping("/transport/{id}")
    public ResponseEntity<String> deleteTransport(@PathVariable int id){
        transportService.deleteTransport(id);
        return new ResponseEntity<>("Transport was deleted", HttpStatus.OK);
    }
}

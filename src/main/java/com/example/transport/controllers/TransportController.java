package com.example.transport.controllers;

import com.example.transport.domain.Transport;
import com.example.transport.service.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportController {
    @Autowired
    private TransportServiceImpl transportService;

    @GetMapping("/transport")
    public List<Transport> getAllTransport(){
        return transportService.getAllTransport();
    }
    @GetMapping("/transport/{id}")
    public Transport getTransportById(@PathVariable int id){
        return transportService.getTransportById(id);
    }
    @PostMapping("/transport")
    public String addNewTransport(@RequestBody Transport transport){
        transportService.addNewTransport(transport);
        return "Ok";
    }
    @PutMapping("/transport/{id}")
    public String updateTransport(@PathVariable int id, @RequestBody Transport transport){
        transportService.updateTransport(id, transport);
        return "Ok";
    }
    @DeleteMapping("/transport/{id}")
    public String deleteTransport(@PathVariable int id){
        transportService.deleteTransport(id);
        return "Ok";
    }
}

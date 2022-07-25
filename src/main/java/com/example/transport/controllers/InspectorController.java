package com.example.transport.controllers;

import com.example.transport.domain.Inspector;
import com.example.transport.service.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InspectorController {
    @Autowired
    private InspectorService inspectorService;


    @GetMapping("/inspectors")
    public List<Inspector> getInspector(){
        return inspectorService.getAllInspector();
}
    @PostMapping("/inspectors")
    public String addNewInspector(@RequestBody Inspector inspector){
        inspectorService.addNewInspector(inspector);
        return "Ok";
    }
    @GetMapping("/inspectors/{id}")
    public Inspector getInspectorsById(@PathVariable int id){
        return inspectorService.getInspectorById(id);
    }
    @PutMapping("/inspectors/{id}")
    public String updateInspector(@PathVariable int id, @RequestBody Inspector inspector){
        inspectorService.updateInspector(id, inspector);
        return "Ok";
    }
    @DeleteMapping("/inspectors/{id}")
    public String deleteInspector(@PathVariable int id){
        inspectorService.deleteInspector(id);
        return "Ok";
    }
}

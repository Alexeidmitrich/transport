package com.example.transport.controllers;

import com.example.transport.domain.Lines;
import com.example.transport.service.LinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinesController {
    @Autowired
    private LinesService linesService;
    @GetMapping("/lines")
    public List<Lines> getAllLines(){
        return linesService.getAllLines();
    }
    @GetMapping("/lines/{id}")
    public Lines getLinesById(@PathVariable int id){
        return linesService.getLinesById(id);
    }
    @PostMapping("/lines")
    public String addNewLines(@RequestBody Lines lines){
        linesService.addNewLines(lines);
        return "Ok";
    }
    @PutMapping("/lines/{id}")
    public String updateLines(@PathVariable int id, @RequestBody Lines lines){
        linesService.updateLines(id, lines);
        return "Ok";
    }
    @DeleteMapping("/lines/{id}")
    public String deleteLines(@PathVariable int id){
        linesService.deleteLines(id);
        return "Ok";
    }
}

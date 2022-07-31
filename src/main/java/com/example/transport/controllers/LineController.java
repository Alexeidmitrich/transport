package com.example.transport.controllers;

import com.example.transport.domain.Line;
import com.example.transport.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineController {
    @Autowired
    private LineService lineService;


    @GetMapping("/lines")
    public List<Line> getAllLine(){
        return lineService.getAllLine();
    }
    @GetMapping("/lines/{id}")
    public Line getLineById(@PathVariable int id){
        return lineService.getLineById(id);
    }
    @PostMapping("/lines")
    public String addNewLine(@RequestBody Line line){
        lineService.addLine(line);
        return "Ok";
    }
    @PutMapping("/lines/{id}")
    public String updateLine(@PathVariable int id, @RequestBody Line line){
        lineService.updateLine(id, line);
        return "Ok";
    }
    @DeleteMapping("/lines/{id}")
    public String deleteLine(@PathVariable int id){
        lineService.deleteLine(id);
        return "Ok";
    }
}

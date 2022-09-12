package com.example.transport.controllers;

import com.example.transport.domain.Line;
import com.example.transport.service.LineService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    public Object getLineById(@PathVariable String id){

        Line li = lineService.getLineById(id);
        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        class  Cl {
            String number;
        }
        return  new Cl(li.getNumber());

    }
    @PostMapping("/lines")
    public String addNewLine(@RequestBody Line line){
        lineService.addLine(line);
        return "Ok";
    }
    @PutMapping("/lines/{id}")
    public String updateLine(@PathVariable String id, @RequestBody Line line){
        lineService.updateLine(id, line);
        return "Ok";
    }
    @DeleteMapping("/lines/{id}")
    public String deleteLine(@PathVariable String id){
        lineService.deleteLine(id);
        return "Ok";
    }
}

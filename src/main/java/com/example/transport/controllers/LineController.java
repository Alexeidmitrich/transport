package com.example.transport.controllers;

import com.example.transport.domain.Line;

import com.example.transport.service.LineService;
import com.example.transport.service.LineServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineController {
    @Autowired
    private LineService lineService;


    @GetMapping("/lines")
    public ResponseEntity<List<Line>> getAllLine(){
        return new ResponseEntity<>(lineService.getAllLine(), HttpStatus.OK);
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
    public ResponseEntity<String> addNewLine(@RequestBody Line line){
       lineService.addLine(line);
        return new ResponseEntity<>("Line was added", HttpStatus.CREATED);
    }

    @PutMapping("/lines/{id}")
    public ResponseEntity<String> updateLine(@PathVariable String id, @RequestBody Line line){
        lineService.updateLine(id, line);
        return new ResponseEntity<>("Line was updated", HttpStatus.OK);
    }

    @DeleteMapping("/lines/{id}")
    public ResponseEntity<String> deleteLine(@PathVariable String id){
        lineService.deleteLine(id);
        return new ResponseEntity<>("Line was deleted", HttpStatus.OK);
    }
}

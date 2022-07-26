package com.example.transport.service;

import com.example.transport.domain.Lines;
import com.example.transport.exception.RoutesException;
import com.example.transport.repository.LinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LinesService {
    @Autowired
    private LinesRepo linesRepo;

    public List<Lines> getAllLines(){
        return linesRepo.findAll();
    }
    public void addNewLines(Lines lines){
        linesRepo.save(lines);
    }
    public void updateLines(int id, Lines lines){
        Lines oldLines = linesRepo.getReferenceById(id);
        oldLines.setId(lines.getId());
        linesRepo.save(oldLines);
    }
    public Lines getLinesById(int id){
        return linesRepo.findById(id).orElseThrow(()->new RoutesException("Lines with number " + id + " was not found"));
    }
    public void deleteLines(int id){
        linesRepo.deleteById(id);
    }
}


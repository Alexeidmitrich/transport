package com.example.transport.service;

import com.example.transport.domain.Line;
import com.example.transport.exception.LinesException;
import com.example.transport.repository.LineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private LineRepo lineRepo;

    @Override
    public List<Line> getAllLine(){
       return lineRepo.findAll();
    }

    @Override
    public Line getLineById(String id){
       return lineRepo.findById(id).orElseThrow(()->new LinesException("Lines with id " + id + " was not found"));
    }

    @Override
    public void addLine(Line lines) {
        lineRepo.save(lines);
    }

    @Override
    public void updateLine(String id, Line lines){
        Line oldLines = lineRepo.getReferenceById(id);
        oldLines.setNumber(lines.getNumber());
        lineRepo.save(oldLines);
    }

    @Override
    public void deleteLine(String id){
        if (!lineRepo.existsById(id)){
            throw new LinesException("Line with id " + id + " not found");
        }
        lineRepo.deleteById(id);
    }
}

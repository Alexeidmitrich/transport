package com.example.transport.service;

import com.example.transport.domain.Line;

import java.util.List;

public interface LineService {
    List<Line> getAllLine();

    Line getLineById(String id);

    void addLine(Line lines);

    void updateLine(String id, Line lines);

    void deleteLine(String id);
}

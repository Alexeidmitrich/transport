package com.example.transport.service;

import com.example.transport.domain.StopTransport;

import java.util.List;

public interface StopTransportService {
    List<StopTransport> getAllStopTransport();

    void addNewStopTransport(StopTransport stopTransport);

    void updateStopTransport(String id, StopTransport stopTransport);

    void deleteStopTransport(String id);

    StopTransport getStopTransportById(String id);
}

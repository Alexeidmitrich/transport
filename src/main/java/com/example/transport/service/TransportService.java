package com.example.transport.service;

import com.example.transport.domain.Transport;

import java.util.List;

public interface TransportService {
    List<Transport> getAllTransport();

    void addNewTransport(Transport transport);

    Transport getTransportById(int id);

    void updateTransport(int id, Transport transport);

    void deleteTransport(int id);
}

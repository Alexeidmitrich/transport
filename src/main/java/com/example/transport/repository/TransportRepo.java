package com.example.transport.repository;

import com.example.transport.domain.Transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepo extends JpaRepository<Transport, Integer> {
}

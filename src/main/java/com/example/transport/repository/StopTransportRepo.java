package com.example.transport.repository;

import com.example.transport.domain.StopTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopTransportRepo extends JpaRepository<StopTransport, Integer> {
}

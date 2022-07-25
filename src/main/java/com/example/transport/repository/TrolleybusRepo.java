package com.example.transport.repository;

import com.example.transport.domain.Trolleybus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrolleybusRepo extends JpaRepository<Trolleybus, Integer> {
}

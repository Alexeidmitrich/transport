package com.example.transport.Repository;

import com.example.transport.Domain.Trolleybus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrolleybusRepo extends JpaRepository<Trolleybus, Integer> {
}

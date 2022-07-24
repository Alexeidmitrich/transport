package com.example.transport.Repository;

import com.example.transport.Domain.Tram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramRepo extends JpaRepository<Tram, Integer> {
}

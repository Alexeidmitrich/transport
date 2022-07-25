package com.example.transport.repository;

import com.example.transport.domain.Tram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramRepo extends JpaRepository<Tram, Integer> {
}

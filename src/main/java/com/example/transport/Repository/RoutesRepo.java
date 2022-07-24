package com.example.transport.Repository;

import com.example.transport.Domain.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepo extends JpaRepository<Routes, Integer> {
}

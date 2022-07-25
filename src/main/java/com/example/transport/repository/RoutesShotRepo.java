package com.example.transport.repository;

import com.example.transport.domain.RoutesShot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesShotRepo extends JpaRepository<RoutesShot, Integer> {
}

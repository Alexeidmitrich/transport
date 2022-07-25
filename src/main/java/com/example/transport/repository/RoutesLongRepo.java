package com.example.transport.repository;

import com.example.transport.domain.RoutesLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesLongRepo extends JpaRepository<RoutesLong, Integer> {
}

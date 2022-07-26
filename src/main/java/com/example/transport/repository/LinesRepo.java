package com.example.transport.repository;

import com.example.transport.domain.Lines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinesRepo extends JpaRepository<Lines, Integer> {
}

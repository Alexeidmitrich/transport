package com.example.transport.repository;

import com.example.transport.domain.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectorRepo extends JpaRepository<Inspector, Integer> {
}

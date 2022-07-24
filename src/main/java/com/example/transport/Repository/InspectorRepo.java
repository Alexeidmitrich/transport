package com.example.transport.Repository;

import com.example.transport.Domain.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectorRepo extends JpaRepository<Inspector, Integer> {
}

package com.example.transport.repository;

import com.example.transport.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyRepo extends JpaRepository<Journey, Integer> {
}

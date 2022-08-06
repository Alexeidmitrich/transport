package com.example.transport.repository;

import com.example.transport.domain.JourneyStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyStopRepo extends JpaRepository<JourneyStop, Integer> {
}

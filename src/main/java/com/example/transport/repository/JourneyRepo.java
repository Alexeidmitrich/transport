package com.example.transport.repository;

import com.example.transport.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface JourneyRepo extends JpaRepository<Journey, Integer> {




}

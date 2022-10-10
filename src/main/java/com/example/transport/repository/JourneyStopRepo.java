package com.example.transport.repository;

import com.example.transport.domain.Journey;
import com.example.transport.domain.JourneyStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JourneyStopRepo extends JpaRepository<JourneyStop, Integer> {

    @Query("SELECT js.journey.date FROM JourneyStop js WHERE js.driver.id = :id OR js.inspector.id = :id")
    List<LocalDate> findAllWorkDayById(@Param("id") String id);
}

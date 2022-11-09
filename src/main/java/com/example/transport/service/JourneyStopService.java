package com.example.transport.service;

import com.example.transport.domain.JourneyStop;

import java.util.List;

public interface JourneyStopService {
    List<JourneyStop> getAllJourney();

    JourneyStop getJourneyById(int id);

    void addNewJourneyStop(JourneyStop journeyStop);

    void updateJourneyStop(int id, JourneyStop journeyStop);

    void deleteJourneyStop(int id);
}

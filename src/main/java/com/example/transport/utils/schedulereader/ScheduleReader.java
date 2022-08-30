package com.example.transport.utils.schedulereader;

import com.example.transport.domain.Journey;
import com.example.transport.domain.Person;

import java.util.List;
import java.util.Map;

public interface ScheduleReader {

    List<Journey> getJourney() throws Exception;
    Map<String, Person> getEmployee() throws Exception;
}

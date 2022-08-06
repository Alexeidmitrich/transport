package com.example.transport.service;

import com.example.transport.domain.Schedule;
import com.example.transport.exception.TransportException;
import com.example.transport.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    public List<Schedule> getAllSchedule(){
        return scheduleRepo.findAll();
    }
    public void addNewSchedule(Schedule schedule){
        scheduleRepo.save(schedule);
    }
    public Schedule getScheduleById(int id){
     return    scheduleRepo.findById(id).orElseThrow(()-> new TransportException("Schedule with id " + id + " was not found"));
    }
    public void updateSchedule(int id, Schedule schedule){
        Schedule oldSchedule = scheduleRepo.getReferenceById(id);
        //oldSchedule.setId(schedule.getId());
        scheduleRepo.save(oldSchedule);
    }
    public void deleteSchedule(int id){
        scheduleRepo.deleteById(id);
    }


    public void uploadService() {


    }
}


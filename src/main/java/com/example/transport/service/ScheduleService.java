package com.example.transport.service;

import com.example.transport.domain.Schedule;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface ScheduleService {
    void saveDataFromFile(MultipartFile file);

    default Path write(MultipartFile file, Path dir) {
        Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }

    List<Schedule> getAllSchedule();

    void addNewSchedule(Schedule schedule);

    Schedule getScheduleById(int id);

    void updateSchedule(int id, Schedule schedule);

    void uploadService();

    //public Path getPdfSchedule(String personId, Integer month){
    Path getPdfSchedule(String personId);
}

package com.example.transport.repository;

<<<<<<<< HEAD:src/main/java/com/example/transport/repository/LineRepo.java
import com.example.transport.domain.Line;
========
import com.example.transport.domain.Lines;
>>>>>>>> main:src/main/java/com/example/transport/repository/LinesRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/com/example/transport/repository/LineRepo.java
public interface LineRepo extends JpaRepository<Line, String> {
========
public interface LinesRepo extends JpaRepository<Lines, Integer> {
>>>>>>>> main:src/main/java/com/example/transport/repository/LinesRepo.java
}

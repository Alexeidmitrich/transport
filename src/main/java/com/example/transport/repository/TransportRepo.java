package com.example.transport.repository;

<<<<<<<< HEAD:src/main/java/com/example/transport/repository/TransportRepo.java
import com.example.transport.domain.Transport;
========
import com.example.transport.domain.StopTransport;
>>>>>>>> main:src/main/java/com/example/transport/repository/StopTransportRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/com/example/transport/repository/TransportRepo.java
public interface TransportRepo extends JpaRepository<Transport, Integer> {
========
public interface StopTransportRepo extends JpaRepository<StopTransport, Integer> {
>>>>>>>> main:src/main/java/com/example/transport/repository/StopTransportRepo.java
}

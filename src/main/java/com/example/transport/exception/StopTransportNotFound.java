package com.example.transport.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StopTransportNotFound extends RuntimeException{

    public StopTransportNotFound(String message) {
        super(message);
    }
}

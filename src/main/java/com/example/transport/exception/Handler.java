package com.example.transport.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StopTransportNotFound.class)
    public final ResponseEntity<Exception> h(Exception ex, WebRequest request) {
        System.out.println("YEAH");
        return null; //new ResponseEntity<>(ex.getMessage(),);
    }
}
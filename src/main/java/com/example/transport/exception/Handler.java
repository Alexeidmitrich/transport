package com.example.transport.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StopTransportNotFound.class)
    public final ResponseEntity<Exception> h(StopTransportNotFound ex) {
        Exception myException = new Exception(ex);
        //System.out.println("YEAH");
        return new ResponseEntity<Exception>(myException, HttpStatus.BAD_REQUEST);
    }
}
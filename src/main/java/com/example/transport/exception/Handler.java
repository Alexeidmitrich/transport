package com.example.transport.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StopTransportNotFound.class)
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, HttpServletResponse response) {
        Exception myException = new Exception(ex);

        return new ResponseEntity<>(myException, HttpStatus.BAD_REQUEST);
    }
}
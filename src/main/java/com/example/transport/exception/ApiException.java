package com.example.transport.exception;

import java.time.ZonedDateTime;

public class ApiException {
    String message;
    Exception exception;
    ZonedDateTime date;

    public ApiException(String message, Exception exception, ZonedDateTime date) {
        this.message = message;
        this.exception = exception;
        this.date = date;
    }

    public ApiException(String message, Exception exception) {
        this(message, exception,ZonedDateTime.now());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}

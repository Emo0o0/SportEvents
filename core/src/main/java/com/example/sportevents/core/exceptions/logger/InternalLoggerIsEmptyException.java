package com.example.sportevents.core.exceptions.logger;

public class InternalLoggerIsEmptyException extends RuntimeException{
    public InternalLoggerIsEmptyException(String message) {
        super(message);
    }
}

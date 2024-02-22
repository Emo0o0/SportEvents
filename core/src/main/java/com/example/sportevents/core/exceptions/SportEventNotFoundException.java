package com.example.sportevents.core.exceptions;

public class SportEventNotFoundException extends RuntimeException {
    public SportEventNotFoundException(String message) {
        super(message);
    }
}

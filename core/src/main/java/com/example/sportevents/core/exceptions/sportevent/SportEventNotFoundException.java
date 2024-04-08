package com.example.sportevents.core.exceptions.sportevent;

public class SportEventNotFoundException extends RuntimeException {
    public SportEventNotFoundException(String message) {
        super(message);
    }
}

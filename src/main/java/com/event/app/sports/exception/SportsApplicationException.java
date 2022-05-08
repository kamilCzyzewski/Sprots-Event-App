package com.event.app.sports.exception;

public class SportsApplicationException extends Exception {

    public SportsApplicationException(String message) {
        super(message);
    }

    public SportsApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.event.app.sports.exception;

public class UserException extends SportsApplicationException{

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}

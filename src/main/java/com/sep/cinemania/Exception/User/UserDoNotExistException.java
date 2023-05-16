package com.sep.cinemania.Exception.User;

public class UserDoNotExistException extends RuntimeException{

    private String message;

    public UserDoNotExistException(String message) {
        super(message);
        this.message = message;
    }
    public UserDoNotExistException() {}



}

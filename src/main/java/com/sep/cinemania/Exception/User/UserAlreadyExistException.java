package com.sep.cinemania.Exception.User;

public class UserAlreadyExistException extends RuntimeException{

    private String message;

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
    public UserAlreadyExistException() {}

}

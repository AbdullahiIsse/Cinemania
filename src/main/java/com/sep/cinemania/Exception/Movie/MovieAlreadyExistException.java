package com.sep.cinemania.Exception.Movie;

public class MovieAlreadyExistException extends RuntimeException{

    private String message;

    public MovieAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
    public MovieAlreadyExistException() {}
}

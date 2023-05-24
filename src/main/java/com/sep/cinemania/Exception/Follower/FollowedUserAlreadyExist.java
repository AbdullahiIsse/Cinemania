package com.sep.cinemania.Exception.Follower;

public class FollowedUserAlreadyExist extends RuntimeException{
    private String message;

    public FollowedUserAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
    public FollowedUserAlreadyExist() {}
}

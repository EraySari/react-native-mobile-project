package com.analysis.project.handler;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String tc) {
        super("User with tc " + tc + " not found.");
    }

}
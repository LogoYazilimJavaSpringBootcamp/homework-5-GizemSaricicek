package com.example.filmplatform.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("There is no user with this informations.");
    }
}

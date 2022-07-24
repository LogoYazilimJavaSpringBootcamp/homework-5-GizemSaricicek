package com.example.filmplatform.exception;

public class UnacceptableMembershipMonth extends RuntimeException {

    public UnacceptableMembershipMonth(String errorMessage) {
        super(errorMessage);
    }
}

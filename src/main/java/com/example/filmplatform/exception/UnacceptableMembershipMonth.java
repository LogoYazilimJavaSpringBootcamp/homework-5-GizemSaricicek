package com.example.filmplatform.exception;

public class UnacceptableMembershipMonth extends RuntimeException {

    public UnacceptableMembershipMonth() {
        super("Cannot be a member. Only 1, 3, 6 and 12 month memberships are available.");
    }
}

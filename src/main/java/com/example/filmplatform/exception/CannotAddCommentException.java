package com.example.filmplatform.exception;

public class CannotAddCommentException extends RuntimeException {

    public CannotAddCommentException() {
        super("The comment could not be added! Users without a membership cannot add comment.");
    }
}

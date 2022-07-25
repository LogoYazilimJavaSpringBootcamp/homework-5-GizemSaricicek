package com.example.filmplatform.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException() {
        super("There is no comment.");
    }
}

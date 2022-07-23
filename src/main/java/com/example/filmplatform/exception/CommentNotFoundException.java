package com.example.filmplatform.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

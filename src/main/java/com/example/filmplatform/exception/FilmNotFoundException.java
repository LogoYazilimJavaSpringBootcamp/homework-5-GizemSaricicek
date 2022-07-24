package com.example.filmplatform.exception;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}

package com.example.filmplatform.exception;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException() {
        super("There is no film.");
    }

}

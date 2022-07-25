package com.example.filmplatform.exception;

public class AddNewFilmException extends RuntimeException {

    public AddNewFilmException() {
        super("The movie could not be added! Users without a membership can add up to 3 movies.");
    }
}

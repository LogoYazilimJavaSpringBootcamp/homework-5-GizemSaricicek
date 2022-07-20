package com.example.filmplatform.controller;

import com.example.filmplatform.model.Film;
import com.example.filmplatform.model.User;
import com.example.filmplatform.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    private List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }
}

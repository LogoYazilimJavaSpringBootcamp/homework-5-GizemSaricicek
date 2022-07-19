package com.example.filmplatform.controller;

import com.example.filmplatform.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

//    @PostMapping
//    private Film createFilm(@RequestBody Film filmRequest) {
//        return filmService.createFilm(filmRequest);
//    }
}

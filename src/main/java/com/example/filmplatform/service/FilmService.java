package com.example.filmplatform.service;

import com.example.filmplatform.model.Film;
import com.example.filmplatform.model.User;
import com.example.filmplatform.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
}

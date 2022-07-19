package com.example.filmplatform.service;

import com.example.filmplatform.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    public Film addFilm(Film film){
//        return filmRepository.saveFilm(film);
//    }
//    public Film createFilm(Film filmRequest) {
//        return filmRepository.save(filmRequest);
//    }
}

package com.example.filmplatform.repository;

import com.example.filmplatform.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
//    Film saveFilm(Film film);
}

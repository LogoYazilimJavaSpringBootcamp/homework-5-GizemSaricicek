package com.example.filmplatform.repository;

import com.example.filmplatform.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findById(Integer id); //id'ye göre film bulmak için
}

package com.example.filmplatform.repository;

import com.example.filmplatform.model.Comment;
import com.example.filmplatform.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByFilmId(Integer id); // film'İn id'sine göre comment bulmak için
    Optional<Comment> findById(Integer id);
}

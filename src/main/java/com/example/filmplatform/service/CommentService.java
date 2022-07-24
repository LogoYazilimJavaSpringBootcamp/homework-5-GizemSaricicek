package com.example.filmplatform.service;

import com.example.filmplatform.exception.CommentNotFoundException;
import com.example.filmplatform.exception.FilmNotFoundException;
import com.example.filmplatform.model.Comment;
import com.example.filmplatform.model.Film;
import com.example.filmplatform.repository.CommentRepository;
import com.example.filmplatform.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    FilmRepository filmRepository;

    public Comment createComment(Integer filmId, Comment commentRequest) {

        Film foundFilm = filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException("There is no film."));
        foundFilm.getCommentList().add(commentRequest); //film'in comment listesine comment ekleniyor
        commentRequest.setFilm(foundFilm);
        filmRepository.save(foundFilm);

        return commentRepository.save(commentRequest);
    }

    public List<Comment> getCommentByFilmId(Integer filmId) {
        Film foundFilm = filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException("There is no film."));
        return commentRepository.findByFilmId(foundFilm.getId());
    }

    public String deleteCommentById(Integer commentId) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("There is no comment."));
        commentRepository.delete(foundComment);
        return "Comment Deleted!";

    }
}

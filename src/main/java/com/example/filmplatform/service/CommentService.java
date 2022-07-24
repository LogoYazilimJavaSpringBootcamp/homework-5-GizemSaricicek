package com.example.filmplatform.service;

import com.example.filmplatform.client.PaymentClient;
import com.example.filmplatform.dto.PaymentDto;
import com.example.filmplatform.exception.*;
import com.example.filmplatform.model.Comment;
import com.example.filmplatform.model.Film;
import com.example.filmplatform.model.User;
import com.example.filmplatform.repository.CommentRepository;
import com.example.filmplatform.repository.FilmRepository;
import com.example.filmplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PaymentClient paymentClient;

    public Comment createComment(Integer userId, Integer filmId, Comment commentRequest) {

        User foundUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());

        List<PaymentDto> payments = paymentClient.getPaymentsByUserId(userId);

        if (payments.isEmpty()) {
            throw new CannotAddCommentException();
        } else{
            Film foundFilm = filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException());
            foundFilm.getCommentList().add(commentRequest); //film'in comment listesine comment ekleniyor
            commentRequest.setFilm(foundFilm);
            filmRepository.save(foundFilm);
        }

        return commentRepository.save(commentRequest);
    }

    public List<Comment> getCommentByFilmId(Integer filmId) {

        Film foundFilm = filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException());
        return commentRepository.findByFilmId(foundFilm.getId());
    }

    public String deleteCommentById(Integer commentId) {
        Comment foundComment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException());
        commentRepository.delete(foundComment);
        return "Comment Deleted!";

    }
}

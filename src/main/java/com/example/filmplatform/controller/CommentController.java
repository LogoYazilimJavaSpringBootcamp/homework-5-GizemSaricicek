package com.example.filmplatform.controller;

import com.example.filmplatform.model.Comment;
import com.example.filmplatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{userId}/{filmId}") //buradaki userId  yorum yapacak kullanıcının id'si
    public Comment createComment(@PathVariable Integer userId, @PathVariable Integer filmId, @RequestBody Comment commentRequest) {
        return commentService.createComment(userId, filmId, commentRequest);
    }

    @GetMapping("/{filmId}")
    public List<Comment> getAllCommentsByFilmId(@PathVariable Integer filmId) {
        return commentService.getCommentByFilmId(filmId);
    }

    @DeleteMapping("/{commentId}")
    public String deleteCommentById(@PathVariable Integer commentId) {
        return commentService.deleteCommentById(commentId);
    }
}

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

    @PostMapping ("/{filmId}")//film'e göre comment ekleme end point'i
    public Comment createComment(@PathVariable Integer filmId, @RequestBody Comment commentRequest) {
        return commentService.createComment(filmId, commentRequest);
    }

    @GetMapping("/{filmId}") // film'e göre comment listesi çıkarmak için end point
    public List<Comment> getAllCommentsByFilmId(@PathVariable Integer filmId){
        return commentService.getCommentByFilmId(filmId);
    }

    @DeleteMapping("/{commentId}") // comment silmek için end point
    public String deleteCommentById(@PathVariable Integer commentId){
        return commentService.deleteCommentById(commentId);
    }
}

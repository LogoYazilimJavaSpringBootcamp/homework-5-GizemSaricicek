package com.example.filmplatform.controller;

import com.example.filmplatform.dto.PaymentDto;
import com.example.filmplatform.model.Film;
import com.example.filmplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.filmplatform.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping(value = "/{id}/payments")
    public PaymentDto makeMembership(@PathVariable Integer id, @RequestBody PaymentDto payment) {
        return userService.makeMembership(id, payment);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/login/{email}/{password}")
    public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @GetMapping(value = "/{id}/films")
    public List<Film> getFilmsById(@PathVariable Integer id) {
        return userService.getFilmsById(id);
    }

    @PutMapping(value = "/{id}/update")
    public User updateUser(@PathVariable Integer id, @RequestBody User userRequest) {
        return userService.updateUser(id, userRequest);
    }

    @PutMapping(value = "/{id}/addFilm")
    public User addFilmToUser(@PathVariable Integer id, @RequestBody Film filmRequest) {
        return userService.addFilmToUser(id, filmRequest);
    }
}

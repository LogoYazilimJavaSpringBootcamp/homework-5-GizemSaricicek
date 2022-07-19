package com.example.filmplatform.controller;

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

    @PostMapping //user kaydı için end point
    public User createUser(@RequestBody User userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping // tüm user'ların listelenmesi için bir end point
    public List<User> getAllUsers(){return userService.getAllUsers();}

    @GetMapping(value = "/login/{email}/{password}") //kullanıcı girişine bakılması için e-mail ve password get ediliyor.
    public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return userService.getUserByEmailAndPassword(email,password);
    }

    @GetMapping(value = "/{id}/films") //user id'ye göre film listesi çekme
    public List<Film> getFilmsById(@PathVariable Integer id){
        return userService.getFilmsById(id);
    }

    @PutMapping(value="/{id}/updateNameAndSurname") //user name ve surname'ini update edebilmek için end point
    public User updateUserNameAndSurname(@PathVariable Integer id, @RequestBody User userRequest){
        return userService.updateUserNameAndSurname(id, userRequest);
    }

    @PutMapping(value="/{id}/updatePassword") //user password'unu update edebilmek için end point
    public User updateUserPassword(@PathVariable Integer id, @RequestBody User userRequest){
        return userService.updatePassword(id, userRequest);
    }

//    @PostMapping(value = "/addFilm/{id}")
//    public Film addFilm(@RequestBody Film filmRequest, @PathVariable Integer id){ return userService.addFilm(filmRequest, id);}

//    @PutMapping("/{userId}/addFilm")
//    public User addFilmToUser( @PathVariable Integer userId, @RequestBody Film filmRequest){
//        return userService.addFilmToUser(userId, filmRequest);
//    }
}

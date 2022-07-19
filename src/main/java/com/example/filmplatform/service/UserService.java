package com.example.filmplatform.service;

import com.example.filmplatform.model.Film;
import com.example.filmplatform.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.filmplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) { return userRepository.save(user); } // user oluşturmak için metod
    public List<User> getAllUsers() {
        return userRepository.findAll();
    } // tüm user'ları listelemek için metod
    public User getUserByEmailAndPassword(String email, String password) { //email ve password'e göre user getirmek için emtod

        User found = userRepository.findByEmailAndPassword(email, password);
        if(found==null){
            throw new RuntimeException(); // eğer user bulunmuyorsa exception throw ediliyor.
        }
        return found;
    }

    public List<Film> getFilmsById(Integer id) { //userId'ye göre filmlerin listelenmesi için metod
        User foundUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return foundUser.getFilmList();
    }

    public User updateUserNameAndSurname(Integer id, User userRequest) { // name ve surname update edilmesi için metod
        User foundUser = userRepository.findById(id).get();
        foundUser.setName(userRequest.getName());
        foundUser.setSurname(userRequest.getSurname());

        return userRepository.save(foundUser);
    }

    public User updatePassword(Integer id, User userRequest) { // password update edilmesi için metod

        User foundUser = userRepository.findById(id).get();
        foundUser.setPassword(userRequest.getPassword());

        return userRepository.save(foundUser);
    }

//    public User addFilmToUser(Integer userId, Film filmRequest) {
//
//        User foundUser = userRepository.findById(userId).get();
//        filmRepository.saveFilm(filmRequest);
//        foundUser.getFilmList().add(filmRequest);
//        return userRepository.save(foundUser);
//    }
}

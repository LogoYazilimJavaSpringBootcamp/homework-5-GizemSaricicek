package com.example.filmplatform.repository;

import com.example.filmplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password); //giriş kontrolü için email ve password bulma
    Optional<User> findById(Integer id); //id'ye göre user bulma
}

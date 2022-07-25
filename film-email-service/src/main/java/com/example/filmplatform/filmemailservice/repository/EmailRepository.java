package com.example.filmplatform.filmemailservice.repository;

import com.example.filmplatform.filmemailservice.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

}



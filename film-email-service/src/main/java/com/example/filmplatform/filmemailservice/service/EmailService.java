package com.example.filmplatform.filmemailservice.service;

import com.example.filmplatform.filmemailservice.model.Email;
import com.example.filmplatform.filmemailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
    public void sendEmail(String email){ //email yollamak için (db'ye veri atıyor.)

        Email emailTemp = new Email();
        emailTemp.setToEmail(email);
        emailTemp.setEmailMessage("Sisteme yeni bir film eklendi.");
        emailTemp.setTitle("Yeni film uyarısı.");
        emailRepository.save(emailTemp);
    }
}

package com.example.filmplatform.filmemailservice.listener;

import com.example.filmplatform.filmemailservice.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j //log atmak için
public class EmailListener {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "filmPlatform.email")
    public void emailListener(String email) { // email dinlemek için

        log.info("email address: {}", email);
        emailService.sendEmail(email);
    }

}
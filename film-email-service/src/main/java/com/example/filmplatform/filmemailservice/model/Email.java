package com.example.filmplatform.filmemailservice.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "film_email")
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String toEmail;
    @Column
    private String title;
    @Column(name = "email_message")
    private String emailMessage;

}

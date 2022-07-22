package com.example.filmplatform.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String name;
    @Column
    private String subject;
    @Column
    private Integer year;
    @ManyToOne
    private User user;
}

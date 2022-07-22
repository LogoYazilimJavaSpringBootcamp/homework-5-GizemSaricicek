package com.example.filmplatform.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String password;

//    @ManyToMany(mappedBy = "userList", cascade = CascadeType.ALL)
//    private List<Film> filmList = new ArrayList<>(10);

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = true)
    private List<Film> filmList = new ArrayList<>(10);
    
}

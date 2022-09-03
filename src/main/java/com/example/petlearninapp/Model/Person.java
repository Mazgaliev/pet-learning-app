package com.example.petlearninapp.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String name;

    private String username;

    private String password;

    private String surname;

    private String phoneNumber;

    @OneToMany
    private List<Course> courses;

    public Person(String name, String username, String password, String surname, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.courses = new ArrayList<>();
    }

    public Person() {

    }
}

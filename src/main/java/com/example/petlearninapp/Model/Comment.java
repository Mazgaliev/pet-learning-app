package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    @OneToOne
    private Person person;

    private String description;

    public Comment(Person person, String description) {
        this.person = person;
        this.description = description;
    }

    public Comment() {

    }
}

package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Person creator;

    private String lessonName;

    private String Description;

    @OneToOne
    private Test test;

    public Lesson(String lessonName, String description, Person creator, Test test) {
        this.lessonName = lessonName;
        this.Description = description;
        this.creator = creator;
        this.test = test;
    }

    public Lesson() {

    }
}

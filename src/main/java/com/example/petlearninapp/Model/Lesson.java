package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Person creator;

    private String lessonName;

    private String Description;

    @OneToOne
    private Animal animal;

    public Lesson(String lessonName, String description, Animal animal, Person creator) {
        this.lessonName = lessonName;
        this.Description = description;
        this.creator = creator;
        this.animal = animal;
    }

    public Lesson() {

    }
}

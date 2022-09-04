package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String courseName;

    private String courseDescription;

    @OneToMany()
    private List<Lesson> lessons;

    @OneToOne(fetch = FetchType.EAGER)
    private Animal animal;

    public Course(String courseName, String courseDescription, List<Lesson> lessons, Animal animal) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.lessons = lessons;
        this.animal = animal;
    }

    public Course() {

    }
}

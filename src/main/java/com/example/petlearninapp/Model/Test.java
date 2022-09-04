package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    private List<Question> questions;

    private Double points;

    public Test(List<Question> questions) {
        this.questions = questions;
        this.points = (double) questions.size();
    }

    public Test() {

    }
}

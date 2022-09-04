package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    private String answer;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "WrongAnswers", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Answer")
    private List<String> wrongAnswers;

    public Question(String name, String description, String answer, List<String> wrongAnswers) {
        this.name = name;
        this.description = description;
        this.answer = answer;
        this.wrongAnswers = wrongAnswers;
    }

    public Question() {

    }
}

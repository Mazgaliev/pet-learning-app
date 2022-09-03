package com.example.petlearninapp.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    @OneToOne
    private Person person;
    @OneToOne
    private Comment comment;

    private LocalDateTime timeStamp;

    public Rating(Person person, Comment comment) {
        this.person = person;
        this.comment = comment;
        this.timeStamp = LocalDateTime.now();
    }

    public Rating() {

    }
}

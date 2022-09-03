package com.example.petlearninapp.Model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String name;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Images", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Images")
    private List<String> images;

    public Animal(String name, String description, List<String> images) {
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public Animal() {

    }
}

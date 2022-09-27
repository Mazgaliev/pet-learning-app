package com.example.petlearninapp.service;

import com.example.petlearninapp.Model.Animal;

import java.util.List;

public interface AnimalService {

    Animal createAnimal(String name, String description, List<String> images);

    void deleteAnimal(Long id);
}

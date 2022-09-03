package com.example.petlearninapp.service;

import java.util.List;

public interface AnimalService {

    void createAnimal(String name, String description, List<String> images);

    void deleteAnimal(Long id);
}

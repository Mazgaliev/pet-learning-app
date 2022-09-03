package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.Model.Animal;
import com.example.petlearninapp.repository.AnimalRepository;
import com.example.petlearninapp.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void createAnimal(String name, String description, List<String> images) {

        this.animalRepository.save(new Animal(name, description, images));
    }

    @Override
    public void deleteAnimal(Long id) {
        Animal a = this.animalRepository.findById(id).get();
        this.animalRepository.delete(a);
    }
}

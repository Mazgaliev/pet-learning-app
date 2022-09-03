package com.example.petlearninapp.repository;

import com.example.petlearninapp.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

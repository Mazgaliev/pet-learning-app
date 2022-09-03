package com.example.petlearninapp.repository;

import com.example.petlearninapp.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

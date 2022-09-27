package com.example.petlearninapp.repository;

import com.example.petlearninapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}

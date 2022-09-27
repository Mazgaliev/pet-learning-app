package com.example.petlearninapp.repository;

import com.example.petlearninapp.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}

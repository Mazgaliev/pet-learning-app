package com.example.petlearninapp.repository;

import com.example.petlearninapp.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

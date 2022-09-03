package com.example.petlearninapp.service;

public interface CourseService {

    void createCourse(String name, String description);

    void deleteCourse(Long courseId);

    void enrollToCourse(Long personId, Long courseId);
}

package com.example.petlearninapp.service;

import com.example.petlearninapp.Model.Course;

import java.util.List;

public interface CourseService {

    void createCourse(String name, String description);

    void deleteCourse(Long courseId);

    void enrollToCourse(Long personId, Long courseId);

    List<Course> findAllCourses();
}

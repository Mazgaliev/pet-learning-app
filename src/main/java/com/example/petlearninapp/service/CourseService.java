package com.example.petlearninapp.service;

import com.example.petlearninapp.Model.Course;
import com.example.petlearninapp.Model.Lesson;

import java.util.List;

public interface CourseService {

    void createCourse(String name, String description, Long animalId, List<Lesson> lessons);

    void deleteCourse(Long courseId);

    void enrollToCourse(Long personId, Long courseId);

    Course findById(Long courseId);

    void updateCourse(Long courseId, List<Lesson> lessons);

    Lesson findLessonById(Long lessonId);

    List<Course> findAllCourses();
}

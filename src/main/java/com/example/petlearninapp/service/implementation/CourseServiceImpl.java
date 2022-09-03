package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.Model.Course;
import com.example.petlearninapp.Model.Person;
import com.example.petlearninapp.repository.CourseRepository;
import com.example.petlearninapp.repository.PersonRepository;
import com.example.petlearninapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final PersonRepository personRepository;

    public CourseServiceImpl(CourseRepository courseRepository, PersonRepository personRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void createCourse(String name, String description) {
        this.courseRepository.save(new Course(name, description, new ArrayList<>()));
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course c = this.courseRepository.findById(courseId).get();

        this.courseRepository.delete(c);
    }

    @Override
    public void enrollToCourse(Long personId, Long courseId) {
        Person p = this.personRepository.findById(personId).get();
        Course c = this.courseRepository.findById(courseId).get();
        List<Course> courses = p.getCourses();
        courses.add(c);
        this.personRepository.save(p);
    }

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }
}

package com.example.petlearninapp.configuration;

import com.example.petlearninapp.Model.Lesson;
import com.example.petlearninapp.Model.Person;
import com.example.petlearninapp.Model.Test;
import com.example.petlearninapp.repository.LessonRepository;
import com.example.petlearninapp.service.AnimalService;
import com.example.petlearninapp.service.CourseService;
import com.example.petlearninapp.service.PersonService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final CourseService courseService;
    private final AnimalService animalService;
    private final PersonService personService;

    private final LessonRepository lessonRepository;

    public DataInitializer(CourseService courseService, AnimalService animalService, PersonService personService, LessonRepository lessonRepository) {
        this.courseService = courseService;
        this.animalService = animalService;
        this.personService = personService;
        this.lessonRepository = lessonRepository;
    }

//    @PostConstruct
    public void initData() {

//        for (int i = 2; i < 5; i++) {
//            this.courseService.createCourse("CourseName", "CourseDescription", Long.parseLong(i + ""), lessons);
//        }

    }
}
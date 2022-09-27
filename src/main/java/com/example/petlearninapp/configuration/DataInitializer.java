package com.example.petlearninapp.configuration;

import com.example.petlearninapp.Model.*;
import com.example.petlearninapp.repository.LessonRepository;
import com.example.petlearninapp.repository.QuestionRepository;
import com.example.petlearninapp.repository.TestRepository;
import com.example.petlearninapp.service.AnimalService;
import com.example.petlearninapp.service.CourseService;
import com.example.petlearninapp.service.PersonService;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DataInitializer {

    private final CourseService courseService;
    private final AnimalService animalService;
    private final PersonService personService;

    private final LessonRepository lessonRepository;
    private final TestRepository testRepository;

    private final QuestionRepository questionRepository;

    public DataInitializer(CourseService courseService, AnimalService animalService, PersonService personService, LessonRepository lessonRepository, TestRepository testRepository, QuestionRepository questionRepository) {
        this.courseService = courseService;
        this.animalService = animalService;
        this.personService = personService;
        this.lessonRepository = lessonRepository;
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
    }

//        @PostConstruct
    public void initData() {
        Animal a = this.animalService.createAnimal("name", "desc", new ArrayList<>());
        Person p = this.personService.registerPerson("name", "surname", "username", "password", "phoneNumber");
        List<Question> questions = List.of(new Question("q1", "desc", "answer", List.of("ans2", "ans3", "ans4")), new Question("q1", "desc", "answer", List.of("ans2", "ans3", "ans4")), new Question("q1", "desc", "answer", List.of("ans2", "ans3", "ans4")), new Question("q1", "desc", "answer", List.of("ans2", "ans3", "ans4")));
        Test test = new Test(questions);
        List<Lesson> lessons = List.of(new Lesson("lname", "ldescc", p, test), new Lesson("lname", "ldescc", p, test), new Lesson("lname", "ldescc", p, test));
        this.questionRepository.saveAll(questions);
        this.testRepository.save(test);
        this.lessonRepository.saveAll(lessons);
        this.courseService.createCourse("cname", "desc", a.getId(), lessons);

    }
}
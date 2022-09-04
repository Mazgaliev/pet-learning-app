package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.Model.Animal;
import com.example.petlearninapp.Model.Course;
import com.example.petlearninapp.Model.Lesson;
import com.example.petlearninapp.Model.Person;
import com.example.petlearninapp.repository.AnimalRepository;
import com.example.petlearninapp.repository.CourseRepository;
import com.example.petlearninapp.repository.LessonRepository;
import com.example.petlearninapp.repository.PersonRepository;
import com.example.petlearninapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final PersonRepository personRepository;

    private final AnimalRepository animalRepository;
    private final LessonRepository lessonRepository;

    public CourseServiceImpl(CourseRepository courseRepository, PersonRepository personRepository, AnimalRepository animalRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
        this.animalRepository = animalRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void createCourse(String name, String description, Long animalId, List<Lesson> lessons) {
        Animal a = this.animalRepository.findById(animalId).get();
        this.courseRepository.save(new Course(name, description, lessons, a));
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
    public Course findById(Long courseId) {
        return this.courseRepository.findById(courseId).get();
    }

    @Override
    public void updateCourse(Long courseId, List<Lesson> lessons) {
        Course c = this.courseRepository.findById(courseId).get();
        List<Lesson> lessonList = c.getLessons();
        for (Lesson l : lessons) {
            if (!lessonList.contains(l)) {
                lessonList.add(l);
            }
        }

        this.courseRepository.save(c);
    }

    @Override
    public Lesson findLessonById(Long lessonId) {
        return this.lessonRepository.findById(lessonId).get();
    }

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }
}

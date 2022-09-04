package com.example.petlearninapp.web;

import com.example.petlearninapp.Model.*;
import com.example.petlearninapp.service.CourseService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public String viewCourse(Model model, @PathVariable Long id) {
        Course course = this.courseService.findById(id);
        List<Lesson> lessonList = course.getLessons();
        model.addAttribute("course", course);
        model.addAttribute("lessons", lessonList);
        model.addAttribute("bodyContent", "SelectedCoursePage");
        return "Master-Template";
    }

    @GetMapping("/lesson/{id}")
    public String viewLesson(Model model, @PathVariable Long id) {
        model.addAttribute("lesson", this.courseService.findLessonById(id));
        model.addAttribute("bodyContent", "LessonPage");

        return "Master-Template";
    }

    @GetMapping("/lesson/test")
    public String viewTest(Model model, @RequestParam Long lessonId) {
        Test test = this.courseService.findLessonById(lessonId).getTest();
        HashMap<Question, List<String>> questionsHashMap = new HashMap<>();

        for (Question q : test.getQuestions()) {
            questionsHashMap.put(q, q.getWrongAnswers());
        }
        model.addAttribute("test", test);
        model.addAttribute("ca", questionsHashMap);
        model.addAttribute("bodyContent", "TestingTemplate");

        return "Master-Template";
    }

    @PostMapping("/enroll/{id}")
    public String enrollToCourse(Authentication authentication, Model model, @PathVariable Long id) {
        Person princial = (Person) authentication.getPrincipal();

        this.courseService.enrollToCourse(princial.getId(), id);
        return "redirect:/home";
    }
}

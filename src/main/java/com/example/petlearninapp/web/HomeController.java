package com.example.petlearninapp.web;

import com.example.petlearninapp.Model.Course;
import com.example.petlearninapp.service.CourseService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/home", "/"})
@CrossOrigin("*")
public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String homePage(Model model, Authentication authentication) {
        List<Course> courses;
        try {
            courses = this.courseService.findAllCourses();
        } catch (Exception e) {
            model.addAttribute("ErrorMsg", e.getMessage());
            model.addAttribute("ErrorCause", e.getCause());
            return "ErrorTemplate";
        }
        model.addAttribute("bodyContent", "HomePage");
        model.addAttribute("courses", courses);
        return "Master-Template";
    }
}

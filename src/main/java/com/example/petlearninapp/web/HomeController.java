package com.example.petlearninapp.web;

import com.example.petlearninapp.service.CourseService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = {"/home", "/"})
public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String homePage(Model model, Authentication authentication) {
        this.courseService.findAllCourses();
        model.addAttribute("bodyContent", "HomePage");

        return "Master-Template";
    }
}

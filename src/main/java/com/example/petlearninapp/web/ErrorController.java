package com.example.petlearninapp.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping

    public String viewError(Model model, @RequestParam Exception exception) {
        model.addAttribute("ErrorMsg", exception.getMessage());
        model.addAttribute("ErrorCause", exception.getCause());
        return "ErrorTemplate";
    }
}

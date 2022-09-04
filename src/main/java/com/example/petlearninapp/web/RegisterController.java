package com.example.petlearninapp.web;

import com.example.petlearninapp.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final PersonService personService;

    public RegisterController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String viewPage(Model model) {
        model.addAttribute("bodyContent", "RegisterPage");
        return "Master-Template";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String phoneNumber) {

        this.personService.registerPerson(name, surname, username, password, phoneNumber);
        return "redirect:/home";
    }
}

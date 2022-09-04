package com.example.petlearninapp.service;

import com.example.petlearninapp.Model.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {


    void registerPerson(String name, String surname, String username, String password, String phoneNumber);

    Person findById(Long personId);


}

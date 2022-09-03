package com.example.petlearninapp.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface PersonService {


    void registerPerson(String name, String surname, String username, String password, String phoneNumber);

    UserDetails loadUserByUsername(String username);
}

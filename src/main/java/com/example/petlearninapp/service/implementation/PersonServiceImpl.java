package com.example.petlearninapp.service.implementation;

import com.example.petlearninapp.Model.Person;
import com.example.petlearninapp.repository.PersonRepository;
import com.example.petlearninapp.service.PersonService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonServiceImpl(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerPerson(String name, String surname, String username, String password, String phoneNumber) {
        String encPw = this.passwordEncoder.encode(password);

        this.personRepository.save(new Person(name,username,encPw,surname,phoneNumber));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return this.personRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/people")

public class PersonController {
    @Autowired
    //Update your controller logic to use the PersonRepository
    private PersonRepository personRepository;
    //List<Person> getPersonList(), Person updatePerson(Person p), and void DeletePerson(int id)
    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(){
        List<Person> people = (List<Person>) personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
    @PostMapping
    public Person createPerson(Person person) {
        return person;
    }
    public Person updatePerson(Person person){
        return person;
    }
    public Person getPerson(int id){
        return null;
    }
}

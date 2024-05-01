package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/people")

public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    //List<Person> getPersonList(), Person updatePerson(Person p), and void DeletePerson(int id)
    public List<Person> getPersonList(){
        return new ArrayList<>();
    }

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

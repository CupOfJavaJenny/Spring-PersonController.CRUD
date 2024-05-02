package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/people")
//^^ setting ("/people")  to default

public class PersonController {
    @Autowired
    //Update your controller logic to use the PersonRepository
    private PersonRepository personRepository;
    //List<Person> getPersonList(), Person updatePerson(Person p), and void DeletePerson(int id)

    //
    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(){
        List<Person> people = (List<Person>) personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
        //taking a list of person,wrapping in a response entity in order to return the list of all people with an OK status 200(code=success!)
    }
    @PostMapping
    //request body is making sure we are getting all required fields to create a new object
    public ResponseEntity<Person> create(@RequestBody Person person){
        //we are telling spring its expecting info about a person entity
        return new ResponseEntity<>((personRepository.save(person)),HttpStatus.CREATED);
        //saving the person we received in the person repository and returning that person we just created with a CREATED status 201((code=success!))
    }
    @PutMapping
    public Person updatePerson(Person person){

        return person;
    }
    @GetMapping("/{id}")//(endpoints) the path to make the reading of a person's ID happen
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        //returning the ability to go in repository and find one specific id with an OK status 200(code=success!)
        return new ResponseEntity<>(personRepository.findOne(id),HttpStatus.OK);
    }
}

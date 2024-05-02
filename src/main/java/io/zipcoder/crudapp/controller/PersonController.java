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
    @PutMapping("/{id}")//curly braces are a path variable
    public ResponseEntity<Person> update(@PathVariable Integer id,@RequestBody Person person){
         //find the person by id
        Person result = personRepository.findOne(id);

        //if that person is not found /null,create a new person
        if(result == null){
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
        }
        //if the person was there, then update the properties, return the modified person ontop of the original person with id provided, and give ok
        result.setFirstName(person.getFirstName());
        result.setLastName(person.getLastName());

        return new ResponseEntity<>(personRepository.save(result), HttpStatus.OK);
    }
    @GetMapping("/{id}")//(endpoints) the path to make the reading of a person's ID happen
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        //returning the ability to go in repository and find one specific id with an OK status 200(code=success!)
        return new ResponseEntity<>(personRepository.findOne(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        personRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       /* DELETE /people/{id} - delete the person with id number {id}
        Response: 204 No Content
        */
    }

    ///*RequestMapping defaults to RequestMethod.GET for its verb, but can take any verb supported by HTTP.
    // The main ones are GET(read), PUT(update), POST(create), and DELETE(destroy/delete).*/
}

package io.zipcoder.crudapp.repository;

import io.zipcoder.crudapp.entity.Person;
import org.springframework.data.repository.CrudRepository;
//Add the @Entity and @Id annotations to your Person class as shown in the Reference section. These tell Spring how to convert your Person objects to database entities when you pass them to a repository.
public interface PersonRepository extends CrudRepository<Person,Integer> {
}

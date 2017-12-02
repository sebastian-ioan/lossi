package org.vizuina.lossi;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.vizuina.lossi.model.Person;

@Log
@Repository
public class PersonRepository extends GenericRepository<Person, Long> {

    public PersonRepository() {
        super(Person.class);
    }
}

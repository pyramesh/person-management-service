package com.ramesh.service;

import com.ramesh.domain.Person;
import com.ramesh.dto.PersonDTO;
import com.ramesh.dto.PersonRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
public interface PersonService {

    void createPerson(PersonRequest personRequest);
    Optional<Person> fetchPersonById(Long personId);
    void deletePersonByPersonId(Long id);

    List<Person> fetchAllPersons();
    void deleteAllPersons();
    Person updatePerson(Long id, PersonDTO personDTO);
}

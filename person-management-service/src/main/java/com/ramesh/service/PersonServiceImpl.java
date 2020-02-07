package com.ramesh.service;

import com.ramesh.domain.Hobby;
import com.ramesh.domain.Person;
import com.ramesh.dto.PersonDTO;
import com.ramesh.dto.PersonRequest;
import com.ramesh.repository.HobbyRepository;
import com.ramesh.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonRepository personRepository;



    @Autowired
    HobbyRepository hobbyRepository;

    @Override
    public void createPerson(PersonRequest personRequest) {
        logger.info("#### start :: PersonServiceImpl :: createPerson ####");
        List<Person> persons = new ArrayList<>();
        personRequest.getPersonDTOS().stream().forEach(personDTO -> {
            Person person = constructDomain(personDTO);
            persons.add(person);
        });
        personRepository.saveAll(persons);
        logger.info("#### end :: PersonServiceImpl :: createPerson ####");
    }

    private Person constructDomain(PersonDTO personDTO) {
        Person p = new Person();
        List<Hobby> hobbies = new ArrayList<>();
        p.setFirstName(Optional.ofNullable(personDTO.getFirstName()).isPresent() ? personDTO.getFirstName() : "");
        p.setLastName(Optional.ofNullable(personDTO.getLastName()).isPresent() ? personDTO.getLastName() : "");
        p.setAge(Optional.ofNullable(personDTO.getAge()).isPresent() ? personDTO.getAge() : "");
        p.setFavouriteColour(Optional.ofNullable(personDTO.getFavouriteColour()).isPresent() ? personDTO.getFavouriteColour() : "");

        if (personDTO.getHobbies() != null)
            personDTO.getHobbies().stream().forEach(hobbyDto -> {
                Hobby h = new Hobby();
                Optional<Hobby> hobby = hobbyRepository.findByName(hobbyDto.getHobbyName());
                if(hobby.isPresent())
                    h.setId(hobby.get().getId());
                h.setName(Optional.ofNullable(hobbyDto.getHobbyName()).isPresent() ? hobbyDto.getHobbyName() : "");
                hobbies.add(h);
            });
        p.setHobbies(hobbies);
        return p;
    }

    @Override
    public Optional<Person> fetchPersonById(Long personId) {
        return personRepository.findById(personId);
    }

    @Override
    public void deletePersonByPersonId(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> fetchAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }

    @Override
    public Person updatePerson(Long id, PersonDTO personDTO) {
        Person person = constructDomain(personDTO);
        person.setId(id);
        return personRepository.save(person);
    }
}

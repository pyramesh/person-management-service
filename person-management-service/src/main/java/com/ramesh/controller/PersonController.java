package com.ramesh.controller;

import com.ramesh.domain.Person;
import com.ramesh.dto.PersonDTO;
import com.ramesh.dto.PersonRequest;
import com.ramesh.dto.PersonResponse;
import com.ramesh.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@RestController
@RequestMapping("/v1/person-service")
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);


    @Autowired
    PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/persons")
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonRequest personRequest, BindingResult result) {
        logger.info("#### start :: PersonController :: createPerson ####");
        long startTime = System.currentTimeMillis();
        personService.createPerson(personRequest);
        long endTime = System.currentTimeMillis();
        PersonResponse response =PersonResponse
                                .builder()
                                .message("Person stored successfully")
                                .errorCode("")
                                .build();
        logger.info("Time Taken {} millisecond",endTime - startTime);
        logger.info("#### end :: PersonController :: createPerson #### {}",new PersonResponse());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<?> fetchAllPersons() {
        List<Person> persons = personService.fetchAllPersons();
        return new ResponseEntity<>(persons.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
    }



    @GetMapping("/persons/{id}")
    public ResponseEntity<?> fetchPersonByPersonId(@PathVariable Long id) {
        logger.info("#### start :: PersonController :: fetchPersonByPersonId ####" +id);
        Optional<Person> person= personService.fetchPersonById(id);
        logger.info("#### end :: PersonController :: fetchPersonByPersonId ####" +person);
        if(person.isPresent()){
           PersonDTO personDTO = convertToDto(person.orElse(null));
            return new ResponseEntity<>(personDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(PersonResponse.builder().message("person is not found").errorCode("").build(), HttpStatus.OK);
        }


    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO person) {
        if (!personService.fetchPersonById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/persons")
    public ResponseEntity<?> deleteAllPersons() {
        personService.deleteAllPersons();
        return new ResponseEntity<>(PersonResponse.builder().message("All Persons are deleted successfully").errorCode("").build(), HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Long id) {
        personService.deletePersonByPersonId(id);
        return new ResponseEntity<>(PersonResponse.builder().message("Person deleted successfully").errorCode("").build(), HttpStatus.OK);
    }

    private PersonDTO convertToDto(Person person) {
        //modelMapper.mapModels(person, PersonDTO.class);
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);
        return  personDTO;
    }

}

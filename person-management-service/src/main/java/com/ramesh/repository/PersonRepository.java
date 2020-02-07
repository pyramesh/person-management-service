package com.ramesh.repository;

import com.ramesh.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

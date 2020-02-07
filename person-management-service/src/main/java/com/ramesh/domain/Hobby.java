package com.ramesh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Entity
@Table(name = "HOBBY")
public class Hobby implements Serializable {

    @Id
    @Column(name = "HOBBY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HOBBY_NAME")
    private String name;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;*/

    @JsonIgnore
    @ManyToMany(mappedBy = "hobbies")
    private List<Person> person = new ArrayList<>();


    public Hobby() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}

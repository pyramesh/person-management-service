package com.ramesh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

   @Id
   @Column(name = "PERSON_ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private String age;

    @Column(name = "FAVOURITE_COLOUR")
    private String favouriteColour;


    /*@OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)*/

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_HOBBY", joinColumns = {
            @JoinColumn(name = "PERSON_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "HOBBY_ID",
                    nullable = false, updatable = false)})
    private List<Hobby> hobbies = new ArrayList<>();


    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String age, String favouriteColor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favouriteColour = favouriteColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}

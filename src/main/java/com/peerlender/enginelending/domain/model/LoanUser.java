package com.peerlender.enginelending.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 *//*
@Entity
public final class User {
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Id
    private  long id;
    private String firstname;
    private String lastName;
    private int age;
    private String occupation;


    public User(String firstname, String lastName, int age, String occupation) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
    }

    public User() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(occupation, user.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastName, age, occupation);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }*/

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table
public class LoanUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2248190721476487645L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idUser;
    private String firstName;
    private String lastName;
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    public LoanUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    public LoanUser(Long idUser, String firstName, String lastName) {
        super();
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
    }



}


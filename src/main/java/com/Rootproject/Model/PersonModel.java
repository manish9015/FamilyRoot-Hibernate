package com.Rootproject.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PersonModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name; 
    private String gender;
    private String profession;
    private LocalDate dob; 

    @ManyToOne
    @JoinColumn(name = "Father_id")
    private PersonModel father;

    @ManyToOne
    @JoinColumn(name = "Mother_id")
    private PersonModel mother;

    @OneToMany(mappedBy = "father", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PersonModel> childrenFromFather = new ArrayList<>();

    @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PersonModel> childrenFromMother = new ArrayList<>();

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public PersonModel getFather() {
        return father;
    }

    public void setFather(PersonModel father) {
        this.father = father;
    }

    public PersonModel getMother() {
        return mother;
    }

    public void setMother(PersonModel mother) {
        this.mother = mother;
    }

    public List<PersonModel> getChildrenFromFather() {
        return childrenFromFather;
    }

    public void setChildrenFromFather(List<PersonModel> childrenFromFather) {
        this.childrenFromFather = childrenFromFather;
    }

    public List<PersonModel> getChildrenFromMother() {
        return childrenFromMother;
    }

    public void setChildrenFromMother(List<PersonModel> childrenFromMother) {
        this.childrenFromMother = childrenFromMother;
    }
}

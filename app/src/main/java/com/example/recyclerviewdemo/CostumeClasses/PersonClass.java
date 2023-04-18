package com.example.recyclerviewdemo.CostumeClasses;

import java.io.Serializable;

public class PersonClass implements Serializable {

    private String personName, personAge;

    public PersonClass() {
    }

    public PersonClass(String personName, String personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAge() {
        return personAge;
    }

    public void setPersonAge(String personAge) {
        this.personAge = personAge;
    }
}

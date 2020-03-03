package com.example.data.transform.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
public class Department {

    private List<Role> roles;
    private List<Person> persons;

    public Department() {
        super();
    }

    public Department(List<Role> roles, List<Person> persons) {
        super();
        this.roles = roles;
        this.persons = persons;
    }

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}

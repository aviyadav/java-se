package com.example.data.transform.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class XMLModel {
    
    private Department department;

    public XMLModel() {
    }

    public XMLModel(Department department) {
        this.department = department;
    }

    @XmlElement(name = "department")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

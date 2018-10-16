package org.sample.xml.domain;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    
    private String name;
    private List<Tutorial> tutorials = new ArrayList<>();

    public Topic() {
    }

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tutorial> getTutorials() {
        return tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }
    
    public void addTutorial(Tutorial tutorial) {
        tutorials.add(tutorial);
    }
}

package org.sample.xml.domain;

import java.util.ArrayList;

public class Topic {
	
	public Topic() {
	}

	public Topic(String name) {
		this.name = name;
	}

	private String name;
	private ArrayList<Tutorial> tutorials = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(ArrayList<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	
	public void addTutorial(Tutorial tutorial) {
		tutorials.add(tutorial);
	}
}

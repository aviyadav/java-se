package org.sample.xml.domain;

import java.util.ArrayList;

public class Channel {
	
	private String name = null;
	private ArrayList<Topic> topics = new ArrayList<>();

	/*
	public Channel() {
	}
	
	public Channel(String name) {
		this.name = name;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
}

package org.sample.xml.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    
    private String name;
    private List<Topic> topics = new ArrayList<>();

    public Channel() {
    }
    
    public Channel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
    
    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}

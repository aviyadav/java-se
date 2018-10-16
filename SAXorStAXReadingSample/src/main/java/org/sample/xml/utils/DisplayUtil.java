package org.sample.xml.utils;

import java.util.Iterator;
import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;

public class DisplayUtil {

    public static void displayChannel(Channel channel) {
        Topic topic;
        System.out.println("channel (name = " + channel.getName() + ")");
        Iterator<Topic> topicsIterator = channel.getTopics().iterator();
        while (topicsIterator.hasNext()) {
            topic = topicsIterator.next();
            System.out.println("\t|__topic (name = " + topic.getName() + ")");
            Iterator<Tutorial> tutorialsIterator = topic.getTutorials().iterator();
            while (tutorialsIterator.hasNext()) {
                System.out.println("\t\t|__tutotial (name = " + tutorialsIterator.next().getName() + ")");
            }
        }
    }
}

package org.sample.xml.stax;

import java.io.File;
import java.util.Iterator;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;

public class XMLEventReaderDriver {
	
	public static final String FILE_NAME = "xml/sample-002.xml";
	public static void main(String[] args) {
		displayChannel(new XMLEventReaderHandler().processXMLFile(new File(FILE_NAME)));
	}
	
	private static void displayChannel(Channel channel) {
		Topic topic = null;
		System.out.println("channel (name = " + channel.getName() + ")");
		Iterator<Topic> topicsIterator = channel.getTopics().iterator();
		while(topicsIterator.hasNext()) {
			topic = topicsIterator.next();
			System.out.println("\t|__topic (name = " + topic.getName() + ")");
			Iterator<Tutorial> tutorialsIterator = topic.getTutorials().iterator();
			while(tutorialsIterator.hasNext()) {
				System.out.println("\t\t|__tutotial (name = " + tutorialsIterator.next().getName() + ")");
			}
		}
	}

}

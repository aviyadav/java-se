package org.sample.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;
import org.xml.sax.SAXException;

public class SAXParserDriver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		SampleHandler handler = new SampleHandler();
		saxParser.parse(new File("xml/sample-002.xml"), handler);
		displayChannel(handler.getChannel());
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

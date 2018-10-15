package org.sample.xml.sax;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XMLReaderDriver {

	public static void main(String[] args) {
		try {
			XMLReader reader = (SAXParserFactory.newInstance().newSAXParser()).getXMLReader();
			SampleHandler handler = new SampleHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("xml/sample-002.xml"));
			displayChannel(handler.getChannel());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

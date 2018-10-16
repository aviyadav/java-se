package org.sample.xml.sax;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SampleFileHandler extends DefaultHandler {
    
    private Channel channel;
    private Topic topic;
    private Tutorial tutorial;
    
    private int currentElement = 0;
    
    private static int TOPIC_ELEMENT = 1;
    private static int TUTORIAL_ELEMENT = 2;

    public Channel getChannel() {
        return channel;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentElement == TUTORIAL_ELEMENT) {
            String value = new String(ch, start, length).trim();
            if(value.length() != 0) {
                tutorial.setName(value);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("topic")) {
            channel.addTopic(topic);
        } else if (qName.equals("tutorial")) {
            topic.addTutorial(tutorial);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("channel")) {
            channel.setName(attributes.getValue("name"));
        } else if (qName.equals("topic")) {
            topic = new Topic();
            topic.setName(attributes.getValue("name"));
            currentElement = TOPIC_ELEMENT;
        } else if (qName.equals("tutorial")) {
            tutorial = new Tutorial();
            currentElement = TUTORIAL_ELEMENT;
        }
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startDocument() throws SAXException {
        channel = new Channel();
    }    
}

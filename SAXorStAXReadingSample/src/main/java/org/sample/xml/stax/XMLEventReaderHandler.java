package org.sample.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;

public class XMLEventReaderHandler {

    public Channel processXMLFile(File xmlFile) {

        Channel channel = null;
        Topic topic = null;
        Tutorial tutorial = null;

        XMLEvent event = null;
        boolean isTutorialFlag = false;

        Characters characters = null;

        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xmlFile));

            while (reader.hasNext()) {
                event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_DOCUMENT:
                        channel = new Channel();
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if ((((StartElement) event).getName()).getLocalPart().equals("channel")) {
                            channel.setName(((StartElement) event).getAttributeByName(new QName("name")).toString());
                        } else if ((((StartElement) event).getName()).getLocalPart().equals("topic")) {
                            topic = new Topic();
                            channel.addTopic(topic);
                            topic.setName(((StartElement) event).getAttributeByName(new QName("name")).toString());
                            isTutorialFlag = false;
                        } else if ((((StartElement) event).getName()).getLocalPart().equals("tutorial")) {
                            tutorial = new Tutorial();
                            topic.addTutorial(tutorial);
                            isTutorialFlag = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters = (Characters) event;
                        if (!(characters.isWhiteSpace() || characters.isIgnorableWhiteSpace())) {
                            if (isTutorialFlag) {
                                tutorial.setName(characters.getData());
                            }
                        }
                        break;

                }
            }
        } catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError ex) {
            Logger.getLogger(XMLEventReaderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return channel;
    }

}

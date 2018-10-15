package org.sample.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.sample.xml.domain.Channel;
import org.sample.xml.domain.Topic;
import org.sample.xml.domain.Tutorial;

public class XMLStreamtReaderHandler {

	public Channel processXMLFile(File xmlFile) {
		
		Channel channel = null;
		Topic topic = null;
		Tutorial tutorial = null;
		
		boolean isTutorialFlag = false;

		try {
			XMLStreamReader reader = (XMLInputFactory.newInstance())
					.createXMLStreamReader(new FileInputStream(xmlFile));

			while (reader.hasNext()) {
				switch (reader.next()) {
				case XMLStreamConstants.START_ELEMENT:
					if (reader.getLocalName().equals("channel")) {
						channel = new Channel();
						channel.setName(reader.getAttributeValue(0));
						isTutorialFlag = false;
					} else if (reader.getLocalName().equals("topic")) {
						topic = new Topic();
						topic.setName(reader.getAttributeValue(0));
						channel.addTopic(topic);
						isTutorialFlag = false;
					} else if (reader.getLocalName().equals("tutorial")) {
						tutorial = new Tutorial();
						topic.addTutorial(tutorial);
						isTutorialFlag = true;
					}

					break;
				case XMLStreamConstants.CHARACTERS:
					if(!reader.isWhiteSpace()) {
						if(isTutorialFlag) {
							tutorial.setName(reader.getText());
						}
					}
					
					break;
				}
			}
		} catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return channel;
	}
}

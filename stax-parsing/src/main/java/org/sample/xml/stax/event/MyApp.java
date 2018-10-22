package org.sample.xml.stax.event;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class MyApp {

    public static void main(String[] args) {

        long _begin = System.nanoTime();

        XMLInputFactory factory = XMLInputFactory.newInstance();

        String startElement = null;
        String endElement = null;
        String elementTxt = null;

        int count = 0;

        try {
            XMLEventReader reader = factory.createXMLEventReader(new InputStreamReader(new FileInputStream("/Applications/programming/temp/data/in/test.xml")));
            while (reader.hasNext()) {
                XMLEvent _event = reader.nextEvent();
                if(_event.isCharacters()) {
                    elementTxt = _event.asCharacters().getData().contains("\n") ? "" : _event.asCharacters().getData().trim();
                }

                if(_event.isStartElement()) {
                    startElement = _event.asStartElement().getName().toString().trim();
                }

                if(_event.isEndElement()) {
                    endElement = _event.asEndElement().getName().toString();
                    if(startElement.equalsIgnoreCase(endElement)) {
                        System.out.println(count++ + " >> ElementName : " + startElement + " ElementText : " + elementTxt);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long _end = System.nanoTime();

        System.out.println("Time elasped in nonoseconds = " + (_end - _begin));
        System.out.println("Time elasped in milliseconds = " + TimeUnit.MILLISECONDS.convert((_end - _begin), TimeUnit.NANOSECONDS));
        System.out.println("Time elasped in seconds = " + TimeUnit.SECONDS.convert((_end - _begin), TimeUnit.NANOSECONDS));
    }
}

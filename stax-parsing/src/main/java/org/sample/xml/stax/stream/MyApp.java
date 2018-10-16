package org.sample.xml.stax.stream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class MyApp {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;

        int count = 0;

        try {
            reader = factory.createXMLStreamReader(new InputStreamReader(new FileInputStream("/Applications/programming/temp/data/in/test.xml")));

            String startElement = null;
            String endElement = null;
            String elementTxt = null;

            while(reader.hasNext()) {
                int _elem = reader.next();
                if(_elem == XMLStreamConstants.START_ELEMENT) {
                    startElement = reader.getLocalName();
                }

                if(_elem == XMLStreamConstants.END_ELEMENT) {
                    endElement = reader.getLocalName();
                    if(startElement.equalsIgnoreCase(endElement)) {
                        // System.out.println(count++ + " >> ElementName : "+ startElement + " ElementText : " + elementTxt);
                    }
                }

                if(_elem == XMLStreamConstants.CHARACTERS) {
                    elementTxt = (reader.getText().contains("\n")) ? "" : reader.getText();
                }
            }


        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("Execution time in nanoseconds - " + (endTime - startTime));

        System.out.println("Execution time in milliseconds - " + (endTime - startTime) / 1000000);

        System.out.println("Execution time in seconds - " + TimeUnit.SECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));

    }
}

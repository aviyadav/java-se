package org.sample.xml.sax;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.sample.xml.utils.DisplayUtil;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XMLReaderDriver {
    
    public static void main(String[] args) {
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            SampleFileHandler handler = new SampleFileHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource("xml/coursera2.xml"));
            DisplayUtil.displayChannel(handler.getChannel());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLReaderDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

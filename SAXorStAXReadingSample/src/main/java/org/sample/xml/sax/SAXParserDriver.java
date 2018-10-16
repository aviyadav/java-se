package org.sample.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.sample.xml.utils.DisplayUtil;
import org.xml.sax.SAXException;

public class SAXParserDriver {
    
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            SampleFileHandler handler = new SampleFileHandler();
                        
            parser.parse(new File("xml/coursera2.xml"), handler);
            DisplayUtil.displayChannel(handler.getChannel());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(SAXParserDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

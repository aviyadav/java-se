package org.sample.xml.stax;

import java.io.File;
import org.sample.xml.utils.DisplayUtil;

public class XMLStreamtReaderDriver {

    public static void main(String[] args) {
        DisplayUtil.displayChannel((new XMLStreamtReaderHandler()).processXMLFile(new File("xml/coursera2.xml")));
    }
}

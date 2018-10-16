package org.sample.xml.stax;

import java.io.File;
import org.sample.xml.utils.DisplayUtil;

public class XMLEventReaderDriver {

    public static final String FILE_NAME = "xml/coursera2.xml";

    public static void main(String[] args) {
        DisplayUtil.displayChannel(new XMLEventReaderHandler().processXMLFile(new File(FILE_NAME)));
    }
}

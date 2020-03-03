package com.example.data.transform.service;

import com.example.data.transform.model.XMLModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLService {

    public XMLModel getObjectFromXmlFile(String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext jaxbctx = JAXBContext.newInstance(XMLModel.class);

            Unmarshaller jaxbUnmarshaller = jaxbctx.createUnmarshaller();
            XMLModel root = (XMLModel) jaxbUnmarshaller.unmarshal(file);

            return root;
        } catch (JAXBException ex) {
            Logger.getLogger(XMLService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void parseObjectToXml(String filePath, XMLModel xmlModel) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(XMLModel.class);

            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshallerObj.marshal(xmlModel, new FileOutputStream(filePath));
        } catch (JAXBException je) {
            System.out.println("JAXBException");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

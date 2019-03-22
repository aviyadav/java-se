package com.sample.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rootelem")
class RootElem {

    List<MyElem> myelem;
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "myelem")
class MyElem {

    @XmlAttribute
    String name;
    @XmlAttribute
    Boolean myatt;
    @XmlElement(name = "key")
    List<Key> keys;
}

@XmlAccessorType(XmlAccessType.FIELD)
class Key {

    @XmlAttribute
    String value;
}

public class Test1 {

    public static void main(String[] args) {
        try {
            RootElem root = JAXB.unmarshal(new FileReader("test.xml"), RootElem.class);
            System.out.println(root);
            JAXB.marshal(root, System.out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

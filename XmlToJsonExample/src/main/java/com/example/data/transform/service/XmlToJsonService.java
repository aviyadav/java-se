package com.example.data.transform.service;

import com.example.data.transform.model.Department;
import com.example.data.transform.model.Person;
import com.example.data.transform.model.Role;
import com.example.data.transform.model.XMLModel;
import java.io.File;
import java.net.URL;
import java.util.List;

public class XmlToJsonService {

    public static void main(String... args) {

//        process("C:\\Users\\q845332\\codebase\\code\\nb-10\\se-samples\\XmlToJsonExample\\src\\main\\resources\\data\\sample.xml", "C:\\Users\\q845332\\codebase\\code\\nb-10\\se-samples\\XmlToJsonExample\\src\\main\\resources\\data\\sample2.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\facility_1282347.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\facility_1282347.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\facility_1282357.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\facility_1282357.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_1.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_1.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_10.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_10.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_2.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_2.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_3.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_3.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_4.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_4.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_5.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_5.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_6.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_6.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_7.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_7.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_8.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_8.json");
        process("C:\\Users\\q845332\\codebase\\data\\xmlsamples\\source\\record_9.xml",
                "C:\\Users\\q845332\\codebase\\data\\xmlsamples\\tgt\\record_9.json");
    }

    public static void process(String source, String target) {
        String filePath = source;
        String filePathOut = target;
//        String filePathIn = "C:\\Users\\q845332\\codebase\\code\\nb-10\\se-samples\\XmlToJsonExample\\src\\main\\resources\\data\\sample.json";
//        String filePathOut2 = "C:\\Users\\q845332\\codebase\\code\\nb-10\\se-samples\\XmlToJsonExample\\src\\main\\resources\\data\\sample2.xml";

        XMLService xmlService = new XMLService();
        XMLModel xmlModel = xmlService.getObjectFromXmlFile(filePath);

//        Department department = xmlModel.getDepartment();
//        List<Role> roles = department.getRoles();
//        List<Person> persons = department.getPersons();
//
//        JsonService jsonService = new JsonService();
//        jsonService.writeDataToJsonFile(filePathOut, roles, persons);
//
//        jsonService.getDataFromJsonFile(filePathIn, roles, persons);
//        department = new Department();
//        department.setRoles(roles);
//        department.setPersons(persons);
//
//        xmlModel.setDepartment(department);
//
//        xmlService.parseObjectToXml(filePathOut2, xmlModel);
    }

    private File getFileFromResources(String fileName) {
        ClassLoader baseLoc = getClass().getClassLoader();
        URL resource = baseLoc.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found");
        } else {
            return new File(resource.getFile());
        }
    }
}

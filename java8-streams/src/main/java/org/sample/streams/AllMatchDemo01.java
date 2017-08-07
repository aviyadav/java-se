package org.sample.streams;

import java.util.ArrayList;
import java.util.List;

public class AllMatchDemo01 {
    
    static int i = 0;
    
    public static void main(String[] args) {
        List<Person3> persons = populateWithData();
        persons.stream().forEach(System.out::println);
        System.out.println("allMatch returned" +
        persons.stream().allMatch(p -> {
            boolean flag = p.getCountry().equals("US");
            System.out.println("[allMatch - Country='US'] pass # " + i++ + " | returns: " + flag);
            return flag;
        }));
    }
    
    private static List<Person3> populateWithData() {
        List<Person3> list = new ArrayList<>();
        list.add(new Person3("person1", "US", 20, 87));
        list.add(new Person3("person2", "Mexico", 25, 90));
        list.add(new Person3("person3", "US", 26, 110));
        list.add(new Person3("person4", "US", 29, 120));
        list.add(new Person3("person5", "Canada", 30, 97));
        return list;
    }
}

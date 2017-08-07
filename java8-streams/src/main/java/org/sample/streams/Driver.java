package org.sample.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        
        List<Person> persons = populatePersons();
        System.out.println("------------- Ids of All persons from US (using filter + map + forEach methods) ------------------");
        persons.stream()
                .filter((Person person) -> person.getCountry().equals("US"))
                .map((Person person) -> "id: " + person.getId() + ", country: " + person.getCountry())
                .forEach(person -> System.out.println(person));
        System.out.println("----------- Ids of All persons not from US (using filter + map + forEach methods) ----------------");
        persons.stream()
                .filter((Person person) -> !person.getCountry().equals("US"))
                .map((Person person) -> "id: " + person.getId() + ", country: " + person.getCountry())
                .forEach(System.out::println);
        System.out.println("------------- using <A> A[] toArray(IntFunction<A[]> generator) method ---------------------------");
        Person[] personArray = persons.stream().toArray(Person[]::new);
        Arrays.asList(personArray).forEach(person -> System.out.println(person.getId()));
        System.out.println("---------------------------- using Object[] toArray method ---------------------------------------");
        Object[] objectArray = persons.stream().toArray();
        Arrays.asList(objectArray).forEach(object -> System.out.println(((Person) object).getCountry()));
    }
    
    private static List<Person> populatePersons() {
        
        List<Person> persons = new ArrayList<>();
        
        persons.add(new Person("p1", "US"));
        persons.add(new Person("p2", "Mexico"));
        persons.add(new Person("p3", "Canada"));
        persons.add(new Person("p4", "US"));
        
        return persons;
    }
}

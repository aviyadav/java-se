package org.sample.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Driver2 {

    public static void main(String[] args) {

        List<Person> persons = populatePersons();

        System.out.println("----- obtain US and Non US based person using partitioningBy & groupingBy --------------------------");
        System.out.println(persons.stream().collect(Collectors.partitioningBy((Person person) -> person.getCountry().equals("US"))));
        System.out.println(persons.stream().collect(Collectors.groupingBy((Person person) -> person.getCountry().equals("US"))));

        System.out.println("----- count US and Non US based person using partitioningBy & groupingBy ---------------------------");
        System.out.println(persons.stream().collect(Collectors.partitioningBy((Person person) -> person.getCountry().equals("US"), Collectors.counting())));
        System.out.println(persons.stream().collect(Collectors.groupingBy((Person person) -> person.getCountry().equals("US"), Collectors.counting())));

        System.out.println("----- obtain the persons in each country and count them by using groupingBy ------------------------");
        System.out.println(persons.stream().collect(Collectors.groupingBy((Person person) -> person.getCountry())));
        System.out.println(persons.stream().collect(Collectors.groupingBy((Person person) -> person.getCountry(), Collectors.counting())));

        System.out.println("----- obtain US and Non US based person using partitioningBy & map names to uppercase using mapping ");
        System.out.println(persons.stream().collect(Collectors.partitioningBy((Person person) -> person.getCountry().equals("US"), Collectors.mapping(p -> p.getId().toUpperCase(), Collectors.toList()))));
        
        System.out.println("----- obtain the persons in each country using groupingBy  & map names to uppercase using mapping --");
        System.out.println(persons.stream().collect(Collectors.groupingBy((Person person) -> person.getCountry(), Collectors.mapping(p -> p.getId().toUpperCase(), Collectors.toList()))));

    }

    private static List<Person> populatePersons() {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("person01", "US"));
        persons.add(new Person("person02", "US"));
        persons.add(new Person("person03", "Brazil"));
        persons.add(new Person("person04", "US"));
        persons.add(new Person("person05", "Brazil"));
        persons.add(new Person("person06", "US"));
        persons.add(new Person("person07", "Germany"));
        persons.add(new Person("person08", "US"));

        return persons;
    }
}

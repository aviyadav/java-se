package org.sample.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Collectors;

public class Driver3 {
    
    public static void main(String[] args) {
        
        List<Person2> persons = populateWithData();
        System.out.println("use Collectors.toList() to obtain list of US based persons");
        List<Person2> listOfPersons = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toList());
        System.out.println(listOfPersons);
        Map<String, List<Person2>> mapOfLists = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toList()));
        System.out.println(mapOfLists);
        System.out.println(mapOfLists.get("US"));
        
        System.out.println("use Collectors.toSet() to obtain set of US based persons");
        Set<Person2> setOfPersons = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toSet());
        System.out.println(listOfPersons);
        Map<String, Set<Person2>> mapOfSets = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toSet()));
        System.out.println(mapOfSets);
        System.out.println(mapOfSets.get("US"));
        
        System.out.println("use Collectors.toCollection(ArrayList::new) to obtain ArrayList of Canada based persons");
        ArrayList<Person2> arraylistOfPersons = persons.stream().filter(p -> p.getCountry().equals("Canada")).collect(Collectors.toCollection(() -> new ArrayList<>()));
        System.out.println(arraylistOfPersons);
        Map<String, List<Person2>> mapOfArrayLists = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(ArrayList::new)));
        System.out.println(mapOfArrayLists);
        System.out.println(mapOfArrayLists.get("Canada"));
        
//        System.out.println("use Collectors.toCollection(Vector::new) to obtain Vector of US based persons");
//        Vector<Person2> vectorOfPersons = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new Vector<>()));
//        System.out.println(vectorOfPersons);
//        Map<String, Vector<Person2>> mapOfVectors = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(Vector::new)));
//        System.out.println(mapOfVectors);
//        System.out.println(mapOfVectors.get("US"));
        
        
        System.out.println("use Collectors.toCollection(Stack::new) to obtain Stack of US based persons");
        Stack<Person2> stackOfUSPersons = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new Stack<>()));
        System.out.println(stackOfUSPersons);
        Map<String, Stack<Person2>> mapOfStack = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(Stack::new)));
        System.out.println(mapOfStack);
        System.out.println(mapOfStack.get("US"));
        
        System.out.println("use Collectors.toCollection(HashSet::new) to obtain HashSet of US based persons");
        HashSet<Person2> hashSetOfUSPersons = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new HashSet<>()));
        System.out.println(hashSetOfUSPersons);
        Map<String, HashSet<Person2>> mapOfHashSet = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(HashSet::new)));
        System.out.println(mapOfHashSet);
        System.out.println(mapOfHashSet.get("US"));
    }
    
    static List<Person2> populateWithData() {
        
        List<Person2> personList = new ArrayList<>();
        
        personList.add(new Person2("JohnA", "US"));
        personList.add(new Person2("JohnB", "US"));
        personList.add(new Person2("JohnC", "Canada"));
        personList.add(new Person2("JohnD", "US"));
        personList.add(new Person2("JohnE", "Canada"));
        personList.add(new Person2("JohnF", "US"));
        personList.add(new Person2("JohnA", "US"));
        personList.add(new Person2("JohnE", "Canada"));
        
        return personList;
    }
}

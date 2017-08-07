package org.sample.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {

     public static Set display(Stream<String> rndStream) {
        System.out.println("constructor");
       Set<String> s= rndStream.collect(Collectors.toSet());
       s.forEach((o) -> {
           System.out.println(o);
         });
       return s;
    }

    public static void main(String[] args) {
	    Set<String> s = new HashSet<>();
	    s.add("Element 1");
	    s.add("Element 2");
	    
	    List<Set<String>> slist = new ArrayList<>();
	    slist.add(s);
	    System.out.println(slist);
	    slist.stream().map((Set<String> str) -> display(str.stream().map(name -> name.concat("!"))));
	    
	    // System.out.println("Hello World!");
    }
}

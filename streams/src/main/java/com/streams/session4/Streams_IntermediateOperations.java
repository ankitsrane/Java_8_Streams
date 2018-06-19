package com.streams.session4;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Streams_IntermediateOperations {
    private static List<Person> personList = new ArrayList<Person>() {{
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
        add(new Person(2345, "ganesh", 30, Person.Gender.MALE, new Address("random city", "randomcode", "banglore"), 20000));
        add(new Person(5654, "kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune"), 25000));
        add(new Person(1987, "mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune"), 20000));
        add(new Person(3466, "sourabh", 32, Person.Gender.MALE, new Address("amanora", "411213", "pune"), 40000));
        add(new Person(3412, "hitesh", 28, Person.Gender.MALE, new Address("hinjewadi", "411213", "pune"), 25000));
        add(new Person(7865, "kalp", 27, Person.Gender.MALE, new Address("magarpatta", "411213", "pune"), 20000));
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
    }};

    public static void main(String[] args) {
        System.out.println("Intermediate Operations");
        stream_sorted_reverseOrder();
    }


    //Skip 2 person from person list and print the names of the rest of the persons
    private static void stream_skip() {
        personList.stream()
                .skip(2)
                .map(person -> person.getName())
                .forEach(System.out::println);
    }

    //print 1st three person names from person List
    private static void stream_limit() {
        personList.stream()
                .map(person -> person.getName())
                .limit(3)
                .forEach(System.out::println);
    }

    //print distinct person names from personList
    private static void stream_distinct() {
        personList.stream()
                .map(person -> person.getName())
                .distinct()
                .forEach(System.out::println);
    }

    //print  person names from personList in sorted order
    private static void stream_sorted() {
        personList.stream()
                .map(person -> person.getName())
                .sorted()
                .forEach(System.out::println);
    }

    //print  person names from personList in reverse order
    private static void stream_sorted_reverseOrder() {
        personList.stream()
                .map(person -> person.getName())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}

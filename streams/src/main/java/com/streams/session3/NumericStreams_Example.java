package com.streams.session3;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreams_Example {

    private static List<Person> personList = new ArrayList<Person>() {{
        add(new Person("ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
        add(new Person("ganesh", 30, Person.Gender.MALE, new Address("random city", "randomcode", "banglore"), 20000));
        add(new Person("kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune"), 25000));
        add(new Person("mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune"), 20000));
    }};

    private static long getSumOfPersonSalaries() {
        return personList.stream()
                .mapToLong(person -> person.getSalary())
                .sum();
    }

    private static void printEvenNumber(int maxRange) {
        IntStream.rangeClosed(0, maxRange)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }

    //Boxed()
    private static List<Integer> getListOfEvenNumber(int maxRange) {
        return IntStream.rangeClosed(0, maxRange)
                .filter(e -> e % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    //mapToObject()
    private static List<Double> getListOfRandomNumber() {
        return IntStream.of(1,2,3,4,5)
                .mapToObj(e -> Math.random())
                .collect(Collectors.toList());
    }
}

package com.streams.session1;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Stream_session1 {
    private static List<Person> personList = new ArrayList<Person>() {{
        add(new Person("ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune")));
        add(new Person("ganesh", 30, Person.Gender.MALE, new Address("random city", "randomcode", "banglore")));
        add(new Person("kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune")));
        add(new Person("mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune")));
    }};


    public static void main(String[] args) {
        System.out.println("Let's begin Streams");
        performLazyEvaluation();
    }

    //map: Get List of Person Names from personList
    private static List<String> getPersonNameList_BeforeJava_Way(List<Person> personList) {
        List<String> personNameList = new ArrayList<>();
        if (personList != null) {
            for (Person person : personList) {
                personNameList.add(person.getName());
            }
        }
        return personNameList;
    }

    //Using Streams
    private static List<String> getPersonNameList_UsingStreams(List<Person> personList) {
        return personList.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }


    //filter: Get List of Person who lives in pune
    private static List<String> getPersonList_BeforeJava_8_Way(List<Person> personList, Predicate<Person> personPredicate) {
        List<String> personNameList = new ArrayList<>();
        if (personList != null) {
            for (Person person : personList) {
                if (personPredicate.test(person)) {
                    personNameList.add(person.getName());
                }
            }
        }
        return personNameList;
    }

    //Using Streams
    private static List<Person> getPersonList_UsingStreams(List<Person> personList, Predicate<Person> personPredicate) {
        return personList.stream()
                .filter(person -> personPredicate.test(person))
                .collect(Collectors.toList());
    }

    //reduce: Get Sum of all person age
    private static int getAgeSum_BeforeJava_Way(List<Person> personList) {
        int sumOfAge = 0;
        if (personList != null) {
            for (Person person : personList) {
                sumOfAge += person.getAge();
            }
        }
        return sumOfAge;
    }

    //Using Streams
    private static int getAgeSum_UsingStreams(List<Person> personList) {
        return personList.stream()
                .map(person -> person.getAge())
                .reduce(0, (total, age) -> total + age);
    }


    //reduce: get Sum of all even numbers
    private static int getSumOfEvenNumbers(List<Integer> intList, Predicate<Integer> intPredicate) {
        int sum = 0;
        //
        for (int value : intList) {
            if (intPredicate.test(value)) {
                sum += value;
            }
            //       }
        }
        return sum;
    }

    //Using Streams
    private static int getSumOfEvenNumbers_usingStreams(List<Integer> intList, Predicate<Integer> intPredicate) {
        return intList.stream()
                .filter(value ->intPredicate.test(value))
                .reduce(0, (sum, value) -> sum + value);
    }


    //abstraction over a collection and lazy evaluation
    private static void performLazyEvaluation() {
        List<Integer> intList = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };

        Stream<Integer> evenNumber = intList.stream()
                .filter(value -> value % 2 == 0);

        intList.add(6);
        intList.add(7);
        intList.add(8);

        evenNumber.forEach(System.out::println);

        //try to run it again, it will give you exception

        // evenNumber.forEach(System.out::println);
    }
}

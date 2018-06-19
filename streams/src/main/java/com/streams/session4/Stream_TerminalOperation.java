package com.streams.session4;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream_TerminalOperation {
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
        System.out.println("Terminate Example");
        stream_reduce();
    }

    //get the count of person who are living in pune
    private static long stream_count() {
        return personList.stream()
                .filter(person -> person.getAddress().getCity().equals("pune"))
                .count();
    }

    //print the personName from personList who are living in pune
    private static void stream_forEach() {
        personList.stream()
                .filter(person -> person.getAddress().getCity().equals("pune"))
                .forEach(System.out::println);
    }

    //print the personName from personList who are living in pune
    private static void stream_matchingOperation() {
        //anyMatch
        //Check whether personList contains any Female person
        boolean genderCheck_Any_Female = personList.stream()
                .anyMatch(person -> person.getGender().equals(Person.Gender.FEMALE));

        //allMatch
        //Check whether personList contains all Male Person
        boolean genderCheck_All_Male = personList.stream()
                .allMatch(person -> person.getGender().equals(Person.Gender.MALE));

        //noneMatch
        //Check whether personList contains No Female Person
        boolean genderCheck_No_Female = personList.stream()
                .noneMatch(person -> person.getGender().equals(Person.Gender.MALE));
    }

    //get the sum of the salaries of all person
    private static void stream_reduce() {

        //Summing salary of person
        personList.stream()
                .map(person -> person.getSalary())
                .reduce(0L, (total, salary) -> total + salary);

        personList.stream()
                .mapToLong(person -> person.getSalary())
                .reduce(0, (total, salary) -> total + salary);


        String[] array = new String[] {"h", "e", "l", "l", "o"};
        String word = Arrays.stream(array)
                .reduce("", (result, value) -> result.concat(value));

        System.out.println(word);

        List<String> lst = Arrays.stream(array)
                .reduce(new ArrayList<String>(), (resultList, value) -> {
                    resultList.add(value);
                    return resultList;
                }, (list1, list2) -> list1);
    }
}

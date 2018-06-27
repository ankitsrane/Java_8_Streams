package com.streams.session4;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Streams_IntermediateOperations {
    private static List<Person> personList = CommonUtility.personList;

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

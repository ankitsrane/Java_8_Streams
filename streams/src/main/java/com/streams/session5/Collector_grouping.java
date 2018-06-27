package com.streams.session5;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collector_grouping {
    private static List<Person> personList = CommonUtility.personList;

    public static void main(String[] args) {
        System.out.println("");
    }

    //group the person based on gender
    private static Map<Person.Gender, List<Person>> groupPersonBasedOnGender() {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getGender()));
    }

    //group the person based on gender
    private static Map<String, List<Person>> groupPersonBasedOnCity() {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAddress().getCity()));
    }

    //group the person based on gender, and city (multilevel grouping)
    private static Map<String, Map<Person.Gender, List<Person>>> groupPersonBasedOnGenderAndAge() {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAddress().getCity(),
                        Collectors.groupingBy(person -> person.getGender())));
    }

    //count the number of person  based on gender
    private static Map<Person.Gender, Long> countPersonBasedOnGender() {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getGender(), Collectors.counting()));
    }

    //group the person based on gender, and city (mapping)
    private static Map<String, Set<String>> groupUniquePersonBasedOCity() {
        return personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAddress().getCity(),
                        Collectors.mapping(person -> person.getName(), Collectors.toSet())));
    }

    //count the number of person  based on gender
    private static long countCount() {
        return personList.stream()
                .collect(Collectors.counting());
    }
}

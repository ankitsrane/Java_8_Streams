package com.streams.session3;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreams_Example {

    private static List<Person> personList = CommonUtility.personList;

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

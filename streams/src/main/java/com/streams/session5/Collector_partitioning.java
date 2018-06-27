package com.streams.session5;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collector_partitioning {
    private static List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    private static List<Person> personList = CommonUtility.personList;

    public static void main(String[] args) {
        System.out.println("reduce Example");
    }

    private static Map<Boolean, List<Integer>> partitionBy(List<Integer> intList){
        return intList.stream()
                    .collect(Collectors.partitioningBy(e -> e%2 == 0));
    }

    private static Map<Boolean, List<Person>> partitionPerson(List<Person> personList){
        return personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAddress().getCity().equals("pune")));
    }

    private static Map<Boolean, Map<Person.Gender, List<Person>>> partitionPersonWithGrouping(List<Person> personList){
        return personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAddress().getCity().equals("pune"),
                        Collectors.groupingBy(person -> person.getGender())));
    }
}

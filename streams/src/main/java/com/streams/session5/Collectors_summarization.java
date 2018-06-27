package com.streams.session5;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors_summarization {
    private static List<Person> personList = CommonUtility.personList;

    public static void main(String[] args) {
       System.out.println(": "+summarizingIntExample(personList)); ;
    }

    //summingInt : Get the sum of the ages of all person
    private static int getSumOfPersonAges(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.summingInt(Person::getAge));
    }

    //averagingInt : Get the average of the ages of all person
    private static double getAverageOfPersonAges(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.averagingInt(Person::getAge));
    }

    //averagingInt : Get the average of the ages of all person
    private static IntSummaryStatistics summarizingIntExample(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
    }
}

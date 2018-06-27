package com.streams.session1;

import com.streams.commonUtil.CommonUtility;
import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_flow_session1_demo2 {
    private static List<Person> personList = CommonUtility.personList;

    public static void main(String[] args) {
        System.out.println("Let's begin Streams");
        System.out.println("result: " + getPersonList_UsingStreams(personList));
    }


    //Using Streams
    private static List<String> getPersonList_UsingStreams(List<Person> personList) {
        Stream<String> nameStream = personList.stream()
                .filter(Stream_flow_session1_demo2::filterPerson)
                .map(Stream_flow_session1_demo2::getPersonName)
                .sorted()
                .limit(3);

        return nameStream.collect(Collectors.toList());
    }

    private static boolean filterPerson(Person person) {
        System.out.println("" + person.getName() + " Inside filter");
        return person.getAddress().getCity().equals("pune");
    }

    private static String getPersonName(Person person) {
        System.out.println("" + person.getName() + " Inside Map");
        return person.getName();
    }
}

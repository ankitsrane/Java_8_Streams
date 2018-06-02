package com.streams.session1;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_flow_session1_demo2 {
    private static List<Person> personList = new ArrayList<Person>() {{
        add(new Person("ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune")));
        add(new Person("ganesh", 30, Person.Gender.MALE, new Address("random city", "randomcode", "banglore")));
        add(new Person("kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune")));
        add(new Person("mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune")));
    }};

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

    private static String getPersonNameByPeekFilter(String name) {
        System.out.println("Name inside  peek filter " + name);
        return name;
    }
}

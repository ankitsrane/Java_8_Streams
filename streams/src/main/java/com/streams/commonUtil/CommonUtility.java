package com.streams.commonUtil;

import com.streams.pojos.Address;
import com.streams.pojos.Person;

import java.util.ArrayList;
import java.util.List;

public class CommonUtility {
    public static List<Person> personList = new ArrayList<Person>() {{
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
        add(new Person(2345,
                "ganesh",
                30,
                Person.Gender.MALE,
                new Address("random city", "randomcode", "banglore"),
                20000));
        add(new Person(5654, "kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune"), 25000));
        add(new Person(1987, "mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune"), 20000));
        add(new Person(3466, "sourabh", 32, Person.Gender.MALE, new Address("amanora", "411213", "pune"), 40000));
        add(new Person(3412, "hitesh", 28, Person.Gender.MALE, new Address("hinjewadi", "411213", "pune"), 25000));
        add(new Person(7865, "kalp", 27, Person.Gender.MALE, new Address("magarpatta", "411213", "pune"), 20000));
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
        add(new Person(1234, "ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune"), 15000));
    }};
}

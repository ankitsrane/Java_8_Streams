package Streams;

import Object.Address;
import Object.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java_Stream_Session1 {

    private static List<Person> personList = new ArrayList<Person>() {{
        add(new Person("ankit", 27, Person.Gender.MALE, new Address("magarapatta", "411028", "pune")));
        add(new Person("ganesh", 30, Person.Gender.MALE, new Address("random city", "randomcode", "banglore")));
        add(new Person("kiran", 28, Person.Gender.MALE, new Address("Hadapsar", "411028", "pune")));
        add(new Person("mayur", 23, Person.Gender.MALE, new Address("viman nagar", "411213", "pune")));
    }};


    public static void main(String[] args) {
        System.out.println("Let's begin Streams");

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        //  System.out.println("age sum: " + getSumOfEvenNumbers(intList));
        //  System.out.println("age sum using streams: " + getSumOfEvenNumbers_usingStreams(intList));
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
        Predicate<Person> personPredicate1 = (Person person) -> person.getAddress().getCity().equals("pune");

        Predicate<Person> personPredicate2 = (Person person) -> person.getAddress().getCity().equals("pune");

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
    private static List<Person> getPersonList_UsingStreams(List<Person> personList) {
        return personList.stream()
                .filter(person -> person.getAddress().getCity() == "pune")
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
    private static int getSumOfEvenNumbers(List<Integer> intList) {
        int sum = 0;
        if (intList != null) {
            for (int value : intList) {
                if (value % 2 == 0) {
                    sum += value;
                }
            }
        }
        return sum;
    }

    //Using Streams
    private static int getSumOfEvenNumbers_usingStreams(List<Integer> intList) {
        return intList.stream()
                .filter(value -> value % 2 == 0)
                .reduce(0, (sum, value) -> sum + value);
    }


    //Using Streams
    private static List<String> getPersonNameList_UsingStreams1(List<Person> personList) {
        return personList.stream()                                              //Stream<Person>
                .filter(person -> person.getAddress().getCity().equals("pune")) //Stream<Person>
                .map(person -> person.getName())                                //Stream<String>
                .collect(Collectors.toList());                                  //List<String>
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

        //try to run it again

        //      evenNumber.forEach(System.out::println);
    }
}

package com.streams.session4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_Streams_FlatMap {
    private static List<String> strList = Arrays.asList("Harry Potter", "X-Men Last-Stand");

    public static void main(String[] args) {
        System.out.println("FlatMap Example");
        // beforeStreamWay();
        flatMapExample();
    }

    private static void beforeStreamWay() {
        for (String line : strList) {
            String[] wordArray = line.split(" ");

            for (String word : wordArray) {
                String[] charArray = word.split("");

                for (String charater : charArray) {
                    System.out.println(charater);
                }
            }
        }
    }

    //print each word of the strList
    private static void flatMapExample() {
        strList.stream()                           //Stream<String>
                .map(e -> e.split(" "))      //Stream<String[]>
                .map(e -> Arrays.stream(e))        //Stream<Stream<String>>
                .forEach(System.out::println);      //it will print the stream

        strList.stream()                           //Stream<String>
                .map(e -> e.split(" "))      //Stream<String[]>
                .flatMap(e -> Arrays.stream(e))        //Stream<Stream<String>> => Stream<String>
                .forEach(System.out::println);      //it will print words

        //Print each character of the words separated by one blank line gap lines
        strList.stream()                                         //Stream<String>
                .map(e -> e.split(" "))                     //Stream<String[]>
                .map(e -> Arrays.stream(e))                      //Stream<Stream<String>>
                .map(e -> e.map(v -> v.split("")))         //Stream<Stream<String[]>>
                .map(e -> e.map(v -> Arrays.stream(v)))          //Stream<Stream<Stream<String>>>>
                .flatMap(e -> e)
                .flatMap(e -> e)
                .forEach(System.out::println);

        //Print each character of the words separated by one blank line gap lines
        strList.stream()                           //Stream<String>
                .map(e -> e.split(" "))      //Stream<String[]>
                .flatMap(e -> Arrays.stream(e))        //Stream<Stream<String>> => Stream<String>
                .map(e -> e.split(""))         //Stream<String[]>
                .flatMap(e -> Arrays.stream(e))
                .forEach(System.out::println);
    }

    //print each word of the strList
    private static void flatMapExample_Numbers() {
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> nestedList =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
                nestedList);

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts = nestedList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " +
                listofInts);
    }
}

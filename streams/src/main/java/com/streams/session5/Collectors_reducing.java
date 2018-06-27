package com.streams.session5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors_reducing {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // getListOfEvenNumbers_usingStreams1(list).forEach(System.out::println);
        // beforeStreamWay();
       System.out.println(list.stream()
                .map(e -> e * e)
                .collect(Collectors.reducing("", (sum, value) -> sum + value.toString())));

    }
    private static int getSumOfSquaresOfNumbers_usingCollector(List<Integer> intList) {
        intList.stream()
                .map(e -> e * e)
                .collect(Collectors.reducing("", (sum, value) -> sum + value.toString()));

        return intList.stream()
                .map(e -> e * e)
                .collect(Collectors.reducing(0, (sum, value) -> sum + value));
    }

    private static int getSumOfSquaresOfNumbers_usingCollectors1(List<Integer> intList) {
        return intList.stream()
                .map(e -> e * e)
                .collect(Collectors.reducing(0, Integer::sum));
    }

}

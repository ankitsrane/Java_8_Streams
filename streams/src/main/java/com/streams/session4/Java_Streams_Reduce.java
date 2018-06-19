package com.streams.session4;

import java.util.ArrayList;
import java.util.List;

public class Java_Streams_Reduce {
    public static void main(String[] args) {
        System.out.println("reduce Example");
        // beforeStreamWay();

    }

    //Using Streams
    private static int getSumOfEvenNumbers_usingStreams(List<Integer> intList) {
        return intList.stream()
                .filter(value -> value % 2 == 0)
                .reduce(0, (sum, value) -> sum + value);
    }

    //Using Streams
    private static List<Integer> getListOfEvenNumbers_usingStreams(List<Integer> intList) {
        return intList.stream()
                .filter(value -> value %2 ==0)
                .reduce(new ArrayList<Integer>(),

                        (list, value) -> {
                            list.add(value);
                            return list;
                        },

                        (list1, list2) -> list1);
    }
}

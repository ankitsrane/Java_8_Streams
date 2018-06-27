package com.streams.session6;

import java.util.Arrays;
import java.util.List;

public class Spliterator_Example {

    public static void main(String args[]) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);

        java.util.Spliterator<Integer> spliterator1 = intList.spliterator();

        System.out.println("Spliterator size1: " + spliterator1.estimateSize());

        java.util.Spliterator<Integer> spliterator2 = spliterator1.trySplit();

        System.out.println("Spliterator size2: " + spliterator2.estimateSize());


        System.out.println("Spliterator size1: " + spliterator1.estimateSize());

        java.util.Spliterator<Integer> spliterator3 = spliterator1.trySplit();

        System.out.println("Spliterator size3: " + spliterator3.estimateSize());


        //try advance()

        //  spliterator3.tryAdvance(System.out::println);

        //    spliterator3.forEachRemaining(System.out::println);

        java.util.Spliterator<Integer> spliterator4 = intList.stream().spliterator();
        spliterator4.forEachRemaining(System.out::println);
    }
}

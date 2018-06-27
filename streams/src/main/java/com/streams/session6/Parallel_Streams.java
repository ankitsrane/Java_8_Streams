package com.streams.session6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parallel_Streams {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        // getEvenNumberListUsingSequencialStream;
        getEvenNumberListUsingParallelStream();
        long end = System.currentTimeMillis();
        System.out.println("Time required to perform operation using parallel stream:" + (end - start));

        long start1 = System.currentTimeMillis();
        getEvenNumberListUsingSequencialStream();
        long end1 = System.currentTimeMillis();
        System.out.println("Time required to perform operation using seq stream:" + (end1 - start1));
    }

    private static void wayToCreateParallelStream() {
        //Creating ParallelStream from Collection
        List<String> nameList = Arrays.asList("John", "Mike", "Ryan", "Donald", "Matthew");
        Stream<String> parallelStrStream = nameList.parallelStream();
        Stream<String> sequentialStream = parallelStrStream.sequential();

        String[] strArray = {"John", "Mike", "Ryan", "Donald", "Matthew"};
        Arrays.stream(strArray).parallel();


        //Using parallel
        Stream<String> strStream = Stream.of("Lets", "learn", "parallel", "streams");
        Stream<String> parallelStreamFromSequencial = strStream.parallel();

        //Numeric Streams
        IntStream intStream = IntStream.range(0, 100);
        IntStream parallelIntStream = intStream.parallel();

        //Convert it back to sequencial Stream
        IntStream sequentialIntStream = parallelIntStream.sequential();
    }

    //Given a range of numbers from 1-1000, print all the Even numbers from it
    private static void getEvenNumberListUsingParallelStream() {
        IntStream.rangeClosed(1, 1000000000)
                .parallel()
                .filter(num -> num % 2 == 0)
                .count();
    }

    private static void getEvenNumberListUsingSequencialStream() {
        IntStream.rangeClosed(1, 1000000000)
                .filter(num -> num % 2 == 0)
                .count();
    }
}

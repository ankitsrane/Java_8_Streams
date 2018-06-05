package com.streams.session2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

//Three kinds of Numeric Stream Supported by Java 8
//IntSTream
//DoubleStream
//LongStream
public class StreamSession2_NumericStream {
    public static void main(String[] args) {
        System.out.println("Let's begin Streams");

        longStream_range_example();
    }

    //get all even number from number ranging from 1-100
    private static void intStream_range_example(){
       int sum = IntStream.range(1,100)
                .filter(e -> e%2 == 0)
                .sum();
    }

    //get all even number from number ranging from 1-100
    private static void longStream_range_example(){
        LongStream.range(1,100)
                .filter(e -> e%2 == 0)
                .forEach(System.out::println);
    }

    private static void intStream_using_list(List<Integer> intList){
       intList.stream()
               .filter(e -> e%2==0)
               .mapToInt( e -> e)
               .forEach(System.out::println);

    }
}

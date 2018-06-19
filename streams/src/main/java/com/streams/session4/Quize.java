package com.streams.session4;

import java.util.stream.IntStream;

public class Quize {
    public static void main(String[] args) {
        whatWillItPrint(); ;
    }

    private static void whatWillItPrint(){

        IntStream.rangeClosed(0,20)
                .filter( e -> e%2==0)
                .skip(5)
                .map(e -> e*e)
                .limit(2)
                .forEach(System.out::println);

    }

    private static void whatWillItPrint1(){

        IntStream.rangeClosed(0,20)
                .filter( e -> e%2==0)
              //  .flatMap(e -> e*e)
                .forEach(System.out::println);

    }
}

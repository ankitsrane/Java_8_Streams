package com.streams.session5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors_joining {

    private static List<String> nameList = Arrays.asList("java", "scala", "phython", "spark" , "ruby");

    public static void main(String[] args) {
        System.out.println(""+joiningExample_prefix_suffix(nameList));
    }

    private static String joiningExample(List<String> names) {
        return names.stream()
                .collect(Collectors.joining("-"));
    }

    private static String joiningExample_prefix_suffix(List<String> names) {
        return names.stream()
                .collect(Collectors.joining("-", "{","}"));
    }
}

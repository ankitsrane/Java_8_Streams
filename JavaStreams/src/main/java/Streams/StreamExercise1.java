package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise1 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ankit", "hitesh", "nivesh", "anchal","ritu", "rajshree");


        //get list of all names whose length is more than 5

        System.out.println("list: "+stringList.stream()
                .filter($-> $.length() >5)
                .collect(Collectors.toList()));



    }
}

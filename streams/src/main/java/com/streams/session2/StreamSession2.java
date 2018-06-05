package com.streams.session2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamSession2 {

    public static void main(String[] args) {
        System.out.println("Let's begin Streams");
    }

    private static void createStream_using_collection() {
        //List
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intListStream = intList.stream();
        intListStream.forEach(System.out::println);

        //Set
        Set<Integer> intSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 1));
        Stream<Integer> intSetStream = intList.stream();
        intSetStream.forEach(System.out::println);
    }

    private static void createStream_using_Arrays() {
        String[] strArray = {"java", "8", "streams"};
        Stream<String> arrayList = Arrays.stream(strArray);
        arrayList.forEach(System.out::println);

        String[][] twoDstrArray = {{"java", "8", "streams"}, {"Lets", "learn", "it"}};
        Stream<String[]> steamOf2DArray = Arrays.stream(twoDstrArray);
        steamOf2DArray.flatMap(e -> Arrays.stream(e))
                .forEach(System.out::println);
    }

    //Print No. of lines from the file
    private static void fileOperation_java6() throws IOException {
        File file = new File("/Users/ankitrane/Desktop/file1.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    //Print No. of lines from the file
    private static void fileOpertion_java7() {
        File file = new File("/Users/ankitrane/Desktop/file1.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Print No. of lines from the file
    private static void fileOperationWithStream() {
        File file = new File("/Users/ankitrane/Desktop/file1.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileOperation_files_Java7() throws IOException {
        Path path = Paths.get("/Users/ankitrane/Desktop/file1.txt");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }

    private static void fileOperation_files_streams() throws IOException {
        Path path = Paths.get("/Users/ankitrane/Desktop/file1.txt");
        Stream<String> lines = Files.lines(path);
        lines.forEach(System.out::println);
    }



    private static void createStream_using_stream_empty() {
        Stream<Integer> emptyStream = Stream.empty();
    }

    //of() takes varArgs as an argument
    private static void createStream_using_stream_of() {
        Stream<String> strStream = Stream.of("Welcome", "to", "java8", "sessions");
        strStream.forEach(System.out::println);
    }


    private static void emptyStreamUseCase(List<Integer> intList) {
        printAllElementsOfStreams(intList == null ? Stream.empty() : intList.stream());
    }

    private static void printAllElementsOfStreams(Stream<Integer> intStream) {
        intStream.filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }
}

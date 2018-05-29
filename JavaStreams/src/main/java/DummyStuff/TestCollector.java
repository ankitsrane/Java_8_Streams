package DummyStuff;

import java.util.*;
import java.util.stream.Collectors;

public class TestCollector {

    public static void main(String args[]){
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,7,1,2,10,15,20,25);

        Set<Integer> intSet = intList.stream().collect(Collectors.toSet());


        Set<Integer> intSet1 = intList.stream().collect(Collectors.toCollection(()->new HashSet<>()));

        System.out.println("set1: "+intSet1);


        Set<Integer> set2 = new HashSet<Integer>(){{add(1);add(10);add(15);add(20);}};

        //This is really bad way, when used with parallel stream it will give ConcurrentModificationException
       // Set<Integer> intSet2 = intList.parallelStream().collect(Collectors.toCollection(()->set2));
         Set<Integer> intSet2 = intList.stream().collect(Collectors.toCollection(()->set2));
        System.out.println("set2: "+intSet2);
    }


}

package DummyStuff;

import java.util.*;
import java.util.stream.Collectors;

public class TestSharedMutability implements Runnable{
    List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,7,1,2,10,15,20,25,13,17,30);

    Set<Integer> set2 = new HashSet<Integer>(){{add(1);add(10);add(15);add(20); add(40);add(17);}};
    List<Integer> intList1 = new ArrayList<Integer>();
    public static void  main(String args[]){
        Thread th1 = new Thread(new TestSharedMutability());
        Thread th2 = new Thread(new TestSharedMutability());
        Thread th3 = new Thread(new TestSharedMutability());
        Thread th4 = new Thread(new TestSharedMutability());
        Thread th5 = new Thread(new TestSharedMutability());
        Thread th6 = new Thread(new TestSharedMutability());
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }

    @Override
    public void run() {



        //This is really bad way, when used with parallel stream it will give ConcurrentModificationException
        // Set<Integer> intSet2 = intList.parallelStream().collect(Collectors.toCollection(()->set2));
        Set<Integer> intSet2 = intList.stream().collect(Collectors.toCollection(()->set2));
        System.out.println("set2: "+intSet2);

        intList1.add(1);
        List<Integer> list = intList.stream().collect(Collectors.toCollection(()->intList1));
        System.out.println("List: "+list);
    }
}

import java.io.*;
import java.util.*;
import java.util.function.*;

public class Chapter3LamdaExpressionDemo1 {

    public static void main(String args[]) throws IOException {
        System.out.println("Inside main method");

        /*Predicate<String> strPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        Predicate<String> strPredicate1 = (String s)-> {return true;};
        */
//        Predicate<String> strPredicate1 = (String s)-> true;

        System.out.println("result1: "+processFile());

        String result = processFile1((BufferedReader br) -> br.readLine()+br.readLine());

        System.out.println("result: "+result);

        //Local Variable with Lamdas
        int localVar = 1000;

        //Cant change varibale which is used in lamda,
        //Variable used in lamda should be final or effectively final(not changing it elsewhere)
        IntConsumer cons = (int i)-> System.out.println(localVar);
      //  localVar = 10001;

        //method reference
        Function<String,Integer> fun1 = (String s)-> Integer.parseInt(s);
        Function<String,Integer> fun2 = Integer::parseInt;

        //MR With Constructor
        Supplier<String>  supp= String::new;
        System.out.println("supp value: "+supp.get());

        //TODO it check for the paraemeterised constructor, if not found gives compile error
        Function<String,String> func = String::new;

        System.out.println("func value: "+func.apply("Hii Ankit"));

        Map<String,Object> map = new HashMap<>();
        map.put("str","String");
        map.put("int",100);


        //Some Methods with lamda expression
        //Comparator  :comapring,reverse,thenComparing
        List<String> stList = Arrays.asList("ankit","abc","bcd");
        stList.sort(Comparator.comparing(String::length).thenComparing(s->s.contains("a")));

        //Predicate: nagate,and,or
        Predicate<String> pred1 = s->s.length()>5;
        Predicate<String> pred2 = s->s.contains("a");

        Predicate<String> pred3 = pred1.negate();

        pred3 = pred1.and(pred2);
        pred3 = pred1.or(pred2);


        //Function:
        Function<Integer,Integer> func1 = x->x+1;
        Function<Integer,Integer> func2 = x->x*2;
        Function<Integer,Integer> func3 = func1.andThen(func2);
        Function<Integer,Integer> func4 = func1.compose(func2);
        System.out.println("function and then result: "+func3.apply(100));
        System.out.println("function compase result: "+func4.apply(100));



    }


    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/ankitrane/Documents/workspaces/DemoWS/Demos/java8Demos/java8/src/main/resources/abc.txt"))){
            return br.readLine();
        }
    }

    public static String processFile1(BufferedReaderProcessor brp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/ankitrane/Documents/workspaces/DemoWS/Demos/java8Demos/java8/src/main/resources/abc.txt"))){
            return brp.process(br);
        }
    }

public interface BufferedReaderProcessor{
    public String process(BufferedReader b) throws IOException;

}

}
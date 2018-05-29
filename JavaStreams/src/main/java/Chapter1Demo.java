import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Chapter1Demo {

    public static void main(String args[]){
        Predicate<String> predicate1 = (String s) -> s.length() >5;
        Predicate<String> predicate2 = (String s) -> s.contains("a");

        System.out.println(testPredicate(predicate1));
        System.out.println(testPredicate(predicate2));

        List<String> strList = Arrays.asList("ankit","ankit");

        List<String> strList1 = Arrays.asList("abc");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("strList1"+strList1);

        System.out.println("List"+ testAnyListAndPredicate(strList,predicate1));


    }

    public static String testPredicate(Predicate<String> predicate){


        if (predicate.test("ankit")){
            return "Hello World!";
        } else {
            return "wrong value";
        }

    }


    public static <T> List<T> testAnyListAndPredicate(List<T> list, Predicate<T> anyPredicate){
        return list.stream()
                    .filter(anyPredicate)
                    .collect(Collectors.toList());

    }
}

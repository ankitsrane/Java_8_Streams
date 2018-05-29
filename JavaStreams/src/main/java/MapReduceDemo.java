import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapReduceDemo {

    public static void main(String args[]) {

        List<String> strList1 = Arrays.asList("abc");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //get the sum of square of all the numbers
        System.out.println("Square root: "+list.stream()
                .map($ -> $*$)
                .reduce(0, (a,b)-> a+b));

        System.out.println("Sum root: "+list.stream()
                .reduce((a, b)-> a+b));

        //return List<Double> containing all the values
        System.out.println("strList1" + strList1);
        String str = String.valueOf(1);
        List<String> stringList = list.stream()
                                        .map(String::valueOf)
                                        .reduce(new ArrayList<String>(),(acc, value)-> {acc.add(value); return acc;} ,(a1,a2)->a1);

        stringList.forEach(System.out::println);



        String Line1 = "ankit rane govind apkesha kiran abc ankit bcg ajijkdnfbdksjfelfk";
        String Line2 = "ankit hitesh govind apkesha kiran abc ankit  anitbcg ajijkdnfbdksjfelfk";

        String[] arry = Line1.split("ankit");
        System.out.println("arra length: " + arry.length);
        List<String> strList2 = new ArrayList<>();
        strList2.add(Line1);
        strList2.add(Line2);
        System.out.println("strList2" + strList2.size());
   /*     Map<String, Integer> map =strList2.stream()
                .map($ -> $.split("ankit"))
                .map($ -> $.length)
                .filter($ -> $>0)
                .collect(Collectors.toMap($ ->"ankit", $ ->  $));*/

        System.out.println(" Map KEy Value :" + strList2.stream()
                .flatMap($ -> Arrays.stream($.split(" ")))
                .filter(word -> !word.isEmpty())
                .map($ -> new AbstractMap.SimpleEntry<>($, 1))
                .reduce(new LinkedHashMap<String, Integer>(), (acc, entry) -> {
                    acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
                    return acc;
                }, (m1, m2) -> m1));


        System.out.println(" Map KEy Value :" + strList2.stream()
                .flatMap($ -> Arrays.stream($.split(" ")))
                .filter(word -> !word.isEmpty())
                .map($ -> new AbstractMap.SimpleEntry<>($, 1))
                .collect(Collectors.toMap($ -> $.getKey(), $ -> $.getValue(), (x, y)-> x+y)));

        strList2.stream()
                    .flatMap($ -> Arrays.stream($.split(" ")))
                    .filter($ -> !$.isEmpty())
                    .map($ -> new AbstractMap.SimpleEntry<>($, 1))
                    .reduce(new LinkedHashMap<String, Integer>(), (acc, entry)-> {
                        acc.put(entry.getKey(), acc.compute(entry.getKey(), (k,v)-> v ==null?1:v+1));
                        return acc;
                    }, (m1, m2)->m1);
    }
}

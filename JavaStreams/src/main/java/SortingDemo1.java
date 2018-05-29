import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingDemo1 {
	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8);
		
		intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();
		
		intList.stream().sorted(Comparator.comparing(a->a.toString())).forEach(System.out::print);
		
		intList.stream().map(e-> e*2).forEach(System.out::println);
		
		List<Integer> newList = intList.stream().filter(e->e%2==0).map(e->new Integer(e)).collect(Collectors.toList());
		newList.forEach(System.out::print);
		
		System.out.println("averagin int"+intList.stream().collect(Collectors.averagingInt(i->i+i)));
		System.out.println("summerising int"+intList.stream().collect(Collectors.summarizingInt(i->i+i)));
	
         intList.stream().collect(Collectors.toMap(Function.identity(), e->e)).forEach((a,b)->System.out.println(a+" "+b));
         
         intList.stream().collect(Collectors.toMap(Function.identity(), e->e, (x,y)->x+y, LinkedHashMap::new));
         
         Map<String, Integer> unsortMap = new HashMap<>();
         unsortMap.put("z", 10);
         unsortMap.put("b", 5);
         unsortMap.put("a", 6);
         unsortMap.put("c", 20);
         unsortMap.put("d", 1);
         unsortMap.put("e", 7);
         unsortMap.put("y", 8);
         unsortMap.put("n", 99);
         unsortMap.put("g", 50);
         unsortMap.put("m", 2);
         unsortMap.put("f", 9);

         System.out.println("Original...");
         System.out.println(unsortMap);

         // sort by keys, a,b,c..., and return a new LinkedHashMap
         // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
         Map<String, Integer> result = unsortMap.entrySet().stream()
                 .sorted(Map.Entry.comparingByKey())
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                         (oldValue, newValue) -> newValue, LinkedHashMap::new));
         Map<String, Integer> result1 = unsortMap.entrySet().stream()
                 .sorted(Map.Entry.comparingByKey())
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                         (oldValue, newValue) -> oldValue, LinkedHashMap::new));
         
         System.out.println(result);
         System.out.println(result1);

	}

}

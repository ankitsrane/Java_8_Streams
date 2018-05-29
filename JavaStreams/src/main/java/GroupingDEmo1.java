import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingDEmo1 {
	
	public static void main(String[] args) {
		
		List<String> strList1 = Arrays.asList("a","b","c","d","a","b",null);
		
		List<String> strList = strList1.stream().filter(Objects::nonNull).collect(Collectors.toList());
		Map<String, Long> map = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Map: "+map);
		
		Map<String,List<Integer>> map1 = strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.mapping(String::length, Collectors.toList())));
		
		System.out.println("Map1: "+map1);
		
		Map<Integer,List<String>> grp = strList1.stream()
												.filter(Objects::nonNull)
												.collect(Collectors.groupingBy(String::length));
		
		System.out.println("New Group By:"+grp);
		
	}

}

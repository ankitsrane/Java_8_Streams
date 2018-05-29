import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferentWaysToDOSumDemo1 {

	public static void main(String[] args) {
		int[] array = {23,43,56,97,32};
		
		System.out.println("sum1: "+Arrays.stream(array).sum());
		
		IntBinaryOperator bo = (x,y)-> x+y;
		
		System.out.println("sum2: "+Arrays.stream(array).reduce(0, bo));
		
		System.out.println("sum3: "+Arrays.stream(array).reduce(0,Integer::sum));
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7);
		
		System.out.println("ListSum1 : "+intList.stream().mapToInt(e->e).sum());
		
		System.out.println("ListSum2 : "+intList.stream().collect(Collectors.summingInt(e->e)));
		
		IntSummaryStatistics intSummary = intList.stream().collect(Collectors.summarizingInt(e->e));
		
		System.out.println("intSummary1: "+intSummary);
		
		IntSummaryStatistics istats = IntStream.of(1,2,3,4,5,6,7).
				collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, 
						IntSummaryStatistics::combine);
		
		System.out.println("intSummary2: "+istats);
		
		System.out.println("Joining example: "+intList.stream().map(String::valueOf).collect(Collectors.joining(":","[","]")));
		
		
		//======================== Prefix Array======================//
		 int[] intArray = {1,2,3,4,5};
		 
		 Arrays.parallelPrefix(intArray, (a,b)->a+b);
		 
		Arrays.stream(intArray).forEach(System.out::println);
		
		
		

	}
}

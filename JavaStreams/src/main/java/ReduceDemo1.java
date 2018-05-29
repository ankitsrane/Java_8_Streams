import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceDemo1 {
	
	public static void main(String[] args) {
		
		System.out.println("Reeduce example");
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(intList.stream().reduce((a,b)-> a*b).get().intValue());
		
		System.out.println(intList.stream().reduce((a,b)->a+b));
		
		System.out.println(intList.stream().reduce(Integer::sum));
		
		System.out.println(intList.stream().reduce(100,Integer::sum));
		 
		
		List<Integer> newList = Arrays.asList(1,2,3,4,5);
		
		System.out.println("3 operation reduce: "+newList.stream().reduce(5, (x,y)->x*y ,(a,b)->+a+b));
	}
	

}

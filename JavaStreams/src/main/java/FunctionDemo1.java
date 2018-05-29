import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDemo1 {
	public static void main(String[] args) {
		/*acceptFunction(new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return t.length();
			}
		});*/
		
		acceptFunction((String t)-> t.length());
		acceptFunction(t->t.length());
		
		acceptFunction(String::length);
		
		List<Integer> lst = Arrays.asList(1,2,3,4,5,6);
		
		BiFunction<List<Integer>, Predicate<Integer>, String> bifunction = 
				(list,predicate)-> {   return "Hello Ankit";};
				
				System.out.println(bifunction.apply(lst, u->u%2==0));;
				
				BiFunction<List<Integer>, Predicate<Integer>, String> bifunction1 = 	(a,b)->"";
		
	}

	public static void acceptFunction(Function<String, Integer> function) {
		System.out.println(function.apply("ankit"));
	}
}

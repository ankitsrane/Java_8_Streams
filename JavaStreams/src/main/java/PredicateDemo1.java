import java.util.function.Predicate;

public class PredicateDemo1 {
	public static void main(String[] args) {
		Predicate<String> p1 = (s1)->  true;
		System.out.println("Str test: "+predicateTestString("ankit",PredicateDemo1::isStringEqual));
	}
	
	static boolean predicateTestString(String str,Predicate<String> pred) {
		if (pred.test(str)) {
			return true;
		}
		
		return false;
	}
	public static boolean isStringEqual(String str) {
		return str.equals("ankit");
	}
	public static boolean isIntegerEqual(Integer inte) {
		return 123==inte;
	}
}

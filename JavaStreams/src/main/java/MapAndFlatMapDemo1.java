import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndFlatMapDemo1 {
	
	private static final List<Integer> VALID_PWD_CHARS = new ArrayList<>();
	static {
	    IntStream.rangeClosed('0', '9').forEach(VALID_PWD_CHARS::add);    // 0-9
	    IntStream.rangeClosed('a', 'z').forEach(VALID_PWD_CHARS::add);    // a-z
		Stream.of(1,2);
	}
	
	public static void main(String[] args) {
		int[][] data = {{1,2},{3,4},{5,6}};
		
		System.out.println(Arrays.stream(data).flatMapToInt(e->Arrays.stream(e)).sum());
		
		int passwordLength = 8;
	    System.out.println("---Generated Password---");
	    for(int i=0;i<5;i++) {
	       new Random().ints(passwordLength, 0, VALID_PWD_CHARS.size())
                            .map(VALID_PWD_CHARS::get).forEach(s -> System.out.print((char) s));
	       System.out.println();
	       
	       BinaryOperator bo = BinaryOperator.maxBy(Comparator.comparing(Integer::intValue));
	       
	    }
		
	}

}

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

////		java.util.stream.IntStreamtream is =
//		java.util.stream.IntStream.rangeClosed(0, 100)
//									.filter(b-> Math.sqrt(b*b+a*a)%1 ==0)
//									.mapToObj(b-> new Integer[] {a,b,Math.sqrt(a*a+b*b)})
//									.collect(Collectors.toList());

		Stream<int[]> triple = IntStream.rangeClosed(1, 100)
								.boxed()
								.flatMap(a ->
											IntStream.rangeClosed(a, 100)
										.filter(b -> Math.sqrt(a*a + b*b) % 1 ==0)
										.mapToObj(b-> new int[] { a, b,(int) Math.sqrt(a*a + b*b)}));

		triple.forEach(t-> System.out.println("triple:"+t[0]+" "+t[1]+" "+t[2]));



		Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
													.boxed()
													.flatMap(a ->
														IntStream.rangeClosed(a, 100)
														.mapToObj(
															b -> new double[] {a, b, Math.sqrt(a*a +b*b)})
														.filter(t -> t[2] % 1 == 0));

		pythagoreanTriples.forEach($ -> System.out.println("triple: "+$[0] + " "+ $[1] + " " +$[2]));
	}

}

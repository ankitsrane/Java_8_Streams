import java.util.ArrayList;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

public class StreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Infinite stream can be created with generate and iterate
		Stream.iterate(new int[] {0,1}, t-> new int[] {t[1], t[0]+t[1]})
				.limit(10)
				.forEach(t->System.out.println(""+t[1]));
		
		//intSupplier for generate fibbonacci series
		
		IntSupplier fib = new IntSupplier() {
			int stvalue =0;
			int ndValue=1;
			
			@Override
			public int getAsInt() {
				int old1st = this.stvalue;
				int nextVal = this.ndValue+this.stvalue;
				this.stvalue=this.ndValue;
				this.ndValue=nextVal;
				return old1st;
			}
		};
		
		IntStream.generate(fib).limit(10).forEach(System.out::println);
	}

}

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo1 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
	
		
		Double averagingInt = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(s->s*1), a->a*a));
		
		System.out.println("averagingInt:"+averagingInt);
		
		list.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresent(System.out::println);
		
		list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).ifPresent(e->System.out.println("Min Element  a list:"+e));
		
		int sum = list.stream().collect(Collectors.summingInt(e->e));
		
		System.out.println("Summing int : "+sum);	
		
	//	Stream.generate(list::size).forEach(System.out::println);
		List<Animal> animalList = new ArrayList<>();
		animalList.add(new Animal());
		animalList.add(new Dog());
		
	
	}

}


class Animal{
	String animalName;

}

class Dog extends  Animal{
	String dogtype;
}

/*
class Generic {
	public <T,R> R methodGeneric(T t){
		return R;
	}
}*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceDemo2 {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8);
		
		System.out.println("MyList: "+intList);
		
		Collections.sort(intList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
	
		Collections.sort(intList,(a,b)->a.compareTo(b));
		System.out.println("Sorted MyList: "+intList);
		
		MyComparator mc = new MyComparator();
		
		Collections.sort(intList, mc::compare);
		Collections.sort(intList,(a,b)->mc.compare(a,b));
		
		intList.stream()
				.sorted(mc::compare)
				.forEach(System.out::print);
		
/*		intList.forEach(new Consumer() {

			@Override
			public void accept(Object t) {
				System.out.println(t);
				
			}
			
		});*/
		
		final List<Person> people = Arrays.asList(new Person("dan"), new Person("laura"));
		
		people.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person t) {
				Person person=(Person)t;
				person.printName();
				
			}
			
		});
		
		people.forEach(Person::printName);
  /*      // Method reference
        people.forEach(Person::printName);
        // Lambda expression
        people.forEach(person -> person.printName());*/
       
	}

}

class Person {
    private String name;
    public Person(final String name) {
        this.name = name;
    }
    public void printName() {
        System.out.println(name);
    }
}

class
MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
	
}
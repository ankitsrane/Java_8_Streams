import java.util.function.Supplier;

public class MethodReferenceDemo1 {
	public static void main(String[] args) {
		PrintName  pn = new PrintName();
		//pn.printName("ankit", NameConverter::convert);
		
		/*pn.printName("ankit", new Parser() {
			
			@Override
			public String parse(String str) {
				// TODO Auto-generated method stub
				return NameConverter.convert(str);
			}
		});*/
		//pn.printName("ankit", (String str) ->{return NameConverter.convert(str);});
		pn.printName("ankit", NameConverter::convert);
		
	}

}

class PrintName{
	public void printName(String name, Parser parser) {
		String parsedNmae = parser.parse(name);
		System.out.println("Name: "+parsedNmae);
	}
}

 interface Parser{
	String parse(String str);
	
}
 
 class NameConverter{
	 
	 public static String convert(String name) {
		 if (name.length()<3) {
			 return name.toLowerCase();
		 } else {
			 return name.toUpperCase();
		 }
		 
	 }
	 public static String convert1(String name) {
		 if (name.length()<3) {
			 return name.toLowerCase();
		 } else {
			 return name.toUpperCase();
		 }
		 
	 }
 }

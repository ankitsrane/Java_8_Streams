import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo1 {
	public static void main(String[] args) {
		/*acceptSuuplier(new Supplier<String>() {

			@Override
			public String get() {
				// TODO Auto-generated method stub
				return "ankit";
			}
			
		});*/
		
		acceptSuuplier(()->"ankit");
		
		List<String> dtrList = new ArrayList<String>();
		//dtrList.add("ankit");
		System.out.println("Empty List:"+dtrList.isEmpty());

		
	}
	
	public static void acceptSuuplier(Supplier<String> strSupplier) {
		String str = strSupplier.get();
		System.out.println("Hey: "+str);
	}

}

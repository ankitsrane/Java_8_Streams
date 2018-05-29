import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LamdawithOPtionalDemo1 {

    public static void main(String args[]){
        Map<String,Integer> map = new HashMap<>();

        List<String> strList = Arrays.asList("ankit","abc");
        List<String> strList1 = Arrays.asList("aa","bb");

        List<String[]> str = strList.stream()
                                        .flatMap(x-> strList1.stream().map(y-> new String[]{x,y}))
                                        .collect(Collectors.toList());

        System.out.println("List: "+str);

        System.out.println("List: "+strList.stream().filter(e-> e.length()>10).findAny().orElse("abc"));

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        System.out.println("reduce multiply: "+num.stream().reduce((a,b)->a*b));
        System.out.println("reduce multiply: "+num.stream().reduce(Integer::sum));
        System.out.println("reduce max: "+num.stream().reduce(Integer::max));
    }

    public static <T, R> R optGet(T t, Function<T, R> provider) {
        return t != null ? provider.apply(t) :  null;
    }
}

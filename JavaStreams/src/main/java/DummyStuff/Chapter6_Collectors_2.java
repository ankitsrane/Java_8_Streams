package DummyStuff;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/*
 * Examples aboiut Collectors.{methods}
 *
 *Methods: grouping, partitioning
 *
 * Because of toString in Dish optional is not visible in output
 *
 * CustomeCollector like groupingBy, SummarizingInt etc
 *
 * Note: cant make inner class instance in satatic method
 *
 *
 * */
public class Chapter6_Collectors_2 {



    public static void main(String[] args){


        //        Map<Boolean, Map<DISHTYPE,List<Dish>>> partwithGroupingHighCalories1 = dishList.stream()
        //                                                        .collect(
        //                                                            partitioningBy(partitioningBy(dish-> dish.getCalories()>300, groupingBy(Dish::getDishType)));

        Map<Boolean,List<Integer>>   primeList=   IntStream.rangeClosed(0,100).boxed().collect(partitioningBy(e->isPrime(e)));
        System.out.println("Prime Number: "+primeList.get(true));

        //Custom Collector
        Map<Boolean,List<Integer>>   primeListByCustomCollector= IntStream.rangeClosed(0,100)
            .collect(
                ()-> new HashMap<Boolean, List<Integer>>(){{
                    put(true, new ArrayList<Integer>());
                    put(false, new ArrayList<Integer>());
                }},
                (acc,intValue)->{
                    acc.get(isPrime(intValue)).add(intValue);
                },
                (map1,map2)->{
                    map1.get(true).addAll(map2.get(true));
                    map1.get(false).addAll(map2.get(false));
                }
                    )  ;

        System.out.println("Prime Number by custome Collector: "+primeList.get(true));

        new Chapter6_Collectors_2().fun1();

    //    Map<Boolean,List<Integer>>   primeListByCustomCollector1= IntStream.rangeClosed(0,10).boxed().collect(new CustomePrimeCollector1());
      //  System.out.println("Prime Number by custom Collector: "+primeListByCustomCollector1);


    }


    static boolean isPrime(int num){

        return IntStream.range(2,num)
            .noneMatch(i-> num%i==0);
    }

    void fun1(){
        Map<Boolean,List<Integer>>   primeListByCustomCollector1= IntStream.rangeClosed(0,100).boxed().collect(new CustomePrimeCollector1());
        System.out.println("Prime Number by custom Collector: "+primeListByCustomCollector1);
    }

    class CustomePrimeCollector1 implements Collector<Integer, Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>>{

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            System.out.println("inside supplier");
            return ()-> new HashMap<Boolean, List<Integer>>(){{
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            System.out.println("inside accumulator");
            return (acc,intValue)->{
                acc.get(isPrime(intValue)).add(intValue);
            };
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            System.out.println("inside Bi operator");
            return (map1,map2)->{
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
        }
    }

}

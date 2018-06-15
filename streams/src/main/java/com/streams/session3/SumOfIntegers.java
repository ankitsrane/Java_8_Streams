package com.streams.Session3;

public class SumOfIntegers {


    private static int sumOfIntegerUptoN_Using_premitive_value(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += i;
        }
        return sum;
    }

    private static int sumOfIntegerUptoN_Using_ObjectValues(int N) {
        Integer sum = 0;
        for (Integer i = 0; i < N; i++) {
            sum += i;
        }
        return sum;
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
       // sumOfIntegerUptoN_Using_ObjectValues(1000000000);
        sumOfIntegerUptoN_Using_premitive_value(1000000000);
        long end = System.currentTimeMillis();
        System.out.println("Time required to perform operation using Integer_values:"+(end - start));
    }
}

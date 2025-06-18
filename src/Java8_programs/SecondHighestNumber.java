package Java8_programs;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {
    public static void main(String[] args) {
        int[] arr={2,4,2,53,23,353,34};
        //not recommandable but java8
        int k= Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(k);
    }
}

package Java8_programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntegerStartswith1 {
    public static void main(String[] args) {
        int[] intArray={1,3,1,3,1,11,34};
        List<String> list = Arrays.stream(intArray).boxed()
                .map(k -> k + "")
                .filter(k1 -> k1.startsWith("1"))
                .toList();
        System.out.println(list);
    }
}

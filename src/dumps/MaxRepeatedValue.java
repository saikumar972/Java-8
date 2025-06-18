package dumps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxRepeatedValue {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,5,7,2,3,2,7,5,8,9,2,13,3,3,3,3);
        Integer repeatedOne=list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
        System.out.println(repeatedOne);

    }
}

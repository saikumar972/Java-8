package dumps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class SecondMostRepeatedElement {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,5,7,2,3,2,7,5,8,9,2,13,3);
        Integer secondRepeatedElement=list.stream().collect(Collectors.groupingBy(i->i,LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("List is empty"));
        System.out.println(secondRepeatedElement);

        Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);
    }
}

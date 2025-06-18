package dumps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueElements {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,3,3,5,7,2);
        //HashSet<Integer> hashSet=new HashSet<>();
        List<Integer> uniqueElements=list.stream()
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                                .entrySet().stream()
                        .filter(entry->entry.getValue()==1)
                                .map(Map.Entry::getKey).toList();
        System.out.println(uniqueElements);
    }
}

package Builtin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateExmple {
    public static void main(String[] args) {
        Predicate<Integer> predicate=k->k>10;
        System.out.println(predicate.test(20));
        List<Integer> list= List.of(2,3,4,55,6,3);
        System.out.println(list.stream().filter(k->k%2==0).toList());
        Map<Integer,String> map=Map.of(1,"one",2,"two",3,"three",4,"four");
        map.entrySet().
                stream().
                filter(k->k.getKey()%2==0).
                forEach(k-> System.out.println(k.getKey()+" "+k.getValue()));
    }
}

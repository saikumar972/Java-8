package Java8_programs;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingNthHighestNumber {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("sare",12);
        map.put("ok",21);
        map.put("raj",23);
        map.put("java",32);
        map.put("c",334);
        map.put("cloud",22);
        //traditional way
        Map.Entry<String, Integer> sorted = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(1);
        System.out.println(sorted);
        //traditional way but nt hardcoding get
        int x=2;
        System.out.println(method(map,x));
        //duplicating values
        Map<String,Integer> map2=new HashMap<>();
        map2.put("sare",12);
        map2.put("ok",12);
        map2.put("raj",23);
        map2.put("java",32);
        map2.put("c",32);
        map2.put("cloud",22);
        Map<Integer, List<String>> collect = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(collect);
        //now doing sorting
        Map.Entry<Integer, List<String>> collect1 = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList().get(1);
        System.out.println(collect1);
    }
    public static  Map.Entry<String, Integer> method(Map<String,Integer> map,int k){
        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(k-1);
    }
}

package dumps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Nthnumber {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(1);
        list.add(7);
        list.add(0);
        list.add(7);
        int k=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of the list elements is "+k);
        //sorting
         int element=list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                 .findFirst()
                 .get();
        System.out.println(element);
        System.out.println("-------------------------------");
        Map<String,Integer> map=new HashMap<>();
        map.put("dd",12);
        map.put("46",32);
        map.put("tygfh",23);
        map.put("jm",43345);
        map.put("dsdh",43345);
        map.put("yui",1222);
        int max=map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .get();
        System.out.println(max);
        for(Map.Entry<String,Integer> local:map.entrySet()){
            if(local.getValue()==max){
                System.out.println(local);
            }
        }
        //group by approach
        Map<Integer, List<String>> collect = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping((entry) -> entry.getKey(), Collectors.toList())));
        System.out.println(collect);
    }
}

package sortings;

import java.util.*;

public class MapSorting {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("one",1);
        map.put("two",2);
        List<Map.Entry<String,Integer>> list= new ArrayList<>(map.entrySet());
        System.out.println(list);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(list);
        list.sort((o1,  o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println(list);
        map.entrySet().stream().
                sorted(Comparator.
                        comparing(Map.Entry::getKey)).
                forEach(k-> System.out.println(k.getKey()+"  "+k.getValue()));
        System.out.println("----------------------------------------------");
        map.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).
                forEach(k-> System.out.println(k.getKey()+"  "+k.getValue()));
    }
}

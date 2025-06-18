package Java8_programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfChar {
    public static void main(String[] args) {
        String k="trywakeupinthemorning";
        Map<Character,Integer> map=new HashMap<>();
        for(char c:k.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }
        System.out.println(map);
       //2nd approach
        Map<Character,Integer> map1=new HashMap<>();
        for(char c:k.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        System.out.println(map1);
        //3rd approach
        String k1="trywakuupearly";
        Map<String, Long> freq = Arrays.stream(k1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);
        Map<Long, List<Map.Entry<String, Long>>> freq1 = Arrays.stream(k1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy((entry) -> entry.getValue()));
        System.out.println(freq1);
        Map<Long, List<String>> collect = Arrays.stream(k1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy((entry) -> entry.getValue(), Collectors.mapping((entry) -> entry.getKey(), Collectors.toList())));
        System.out.println(collect);
    }
}

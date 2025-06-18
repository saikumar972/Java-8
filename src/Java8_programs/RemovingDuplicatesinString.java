package Java8_programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemovingDuplicatesinString {
    public static void main(String[] args) {
        String k1="treycheyalidaily";
        Map<Character,Integer> map=new HashMap<>();
        for(char c:k1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map);
        //removing duplicates meaning removing the set containing value>1
        Map<Character, Integer> uniques = map.entrySet().stream()
                .filter((k) -> k.getValue() == 1).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
        System.out.println(uniques);
        //printing duplicates
        String k2="treycheyalidaily";
        List<String> duplicates = Arrays.stream(k2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() > 1)
                .map(s -> s.getKey())
                .sorted()
                .toList();
        System.out.println(duplicates);
        //first non repeating character
        String k3="ilovejavatechie";
        String character = Arrays.stream(k3.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 1)
                .map(s -> s.getKey())
                .findFirst().get();
        System.out.println(character);
    }
}

package BiConsumers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample {
    public static void main(String[] args) {
        //BiConsumer giving two lists and getting the distinct list of elements
        List<Integer> list1=List.of(1,33,6,2,1,33,70);
        List<Integer> list2=List.of(32,23,53,2,4,55,5,3,4,2);
        List<Integer> result=Stream.of(list1,list2)
                .flatMap(r->r.stream())
                .distinct()
                .toList();
        System.out.println(result);
        System.out.println("------------------------------------------");
        //just streams
        Stream<Integer> stream=Stream.of(list1,list2).flatMap(Collection::stream);
        stream.forEach(k-> System.out.print(k+" "));
        System.out.println("\n"+"------------------------------------------");
        //using bifunction
        BiFunction<List<Integer>, List<Integer>,List<Integer>> resultList=(list, listt) ->
                Stream.of(list,listt)
                        //flatMap(k->k.stream())
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
        resultList.apply(list1, list2).forEach(k -> System.out.print(k + " "));
        System.out.println("\n" + "---------------------------");
        //using andThen
        Function<List<Integer>, List<Integer>> sorting = l -> l.stream()
                .sorted()
                .toList();
        System.out.println(resultList.andThen(sorting).apply(list1, list2));
        //it is used in replaceAll method in map object
        Map<String,Integer> map=Map.of("ok",1,"sare",90,"tike",3,"word",27);
        //since map.of provides immutable we cannot modify that one
        //adding 100 to value
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("sai",2);
        map1.put("kumar",43);
        map1.put("rajveer",65);
        System.out.print("before modification ");
        System.out.println(map1);
        //replaceAll changes value only
        map1.replaceAll((k,v)->v+100);
        System.out.print("after modification ");
        System.out.println(map1);
        Map<String, Integer> mutableMap = new HashMap<>(map);
        mutableMap.replaceAll((k,v)->v+100);
        System.out.println(mutableMap);
        System.out.println(map);

    }
}

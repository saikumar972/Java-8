package Builtin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Supplierexample {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,3,4,5,44,22,2);
        List<Integer> filteredList=list.
                stream().
                filter(k->k>100).
                collect(Collectors.toList());
        Supplier<List<Integer>> dummyList=()->List.of(0,0);
        List<Integer> result=filteredList.isEmpty()?dummyList.get():filteredList;
        System.out.println(result);
        List<Integer> emptyList = List.of(); // Correct way to create an empty list
        Supplier<Integer> supplier3=()->1000;
        System.out.println(emptyList.stream().findAny().orElseGet(supplier3));
        Supplier<List<Integer>> supplier2 = () -> emptyList.stream()
                .findAny()
                .map(Collections::singletonList)  // Converts Integer to a list if present
                .orElseGet(() ->  List.of(1,2));  // Provides default list when not present
        System.out.println(supplier2.get());
        List<Integer> emptyList1 = new ArrayList<>();  // This initializes emptyList as an empty list.
        Supplier<Integer> supplier4 = () -> emptyList1.stream()
                .findAny()
                .orElseGet(() -> 11111);
        System.out.println(supplier4.get());  // It will return [1, 2, 3] because emptyList is empty.


    }
}

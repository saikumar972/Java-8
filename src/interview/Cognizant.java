package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cognizant {
    public static void main(String[] args) {
        String application="code-function,code-nonfunction,something-ok,code-not,something-notok,noncode-edo,code-eddd";
        Set<Map.Entry<String, Long>> collect = Arrays.stream(application.split(","))
                .map(s -> s.substring(0, s.indexOf('-')))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("-------------------------------------------------------");
        Map<String, Long> collect2 = Arrays.stream(application.split(","))
                .map(s -> s.substring(0, s.indexOf('-')))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<String,Long>::getValue).reversed())
                //.peek(entry-> System.out.println(entry))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry->entry.getValue()
                ));

        System.out.println(collect2);
    }
}

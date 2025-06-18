package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cog {
    public static void main(String[] args) {
        String application="code-function,code-nonfunction,something-ok,code-not,something-notok,noncode-edo,code-eddd";
      Arrays.stream(application.split(","))
                .map(s -> s.substring(0, s.indexOf('-')))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
//                .map(entry -> {
//                    String key = entry.getKey();
//                    Long value = entry.getValue();
//                    Map<String, Long> map = new LinkedHashMap();
//                    map.put(key, value);
//                    return map;
//                })
               .forEach(System.out::println);

    }
}

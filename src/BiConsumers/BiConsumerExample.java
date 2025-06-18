package BiConsumers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer=(s1,s2)-> System.out.println(s1.concat(s2));
        biConsumer.accept("sare","okok");
        //it is used on forEach method in map
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(45,33);
        map.put(4,4);
        map.forEach((k,v)-> System.out.println(k+" "+v));

    }
}

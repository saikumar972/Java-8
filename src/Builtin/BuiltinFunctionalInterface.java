package Builtin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BuiltinFunctionalInterface {
    public static void main(String[] args) {
        Consumer<Integer> consumer=k-> System.out.println("number= "+k);
        consumer.accept(21);
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        //forEach uses consumer interface
        list.forEach(k-> System.out.println("number "+k));
        list.forEach(consumer);
    }
}

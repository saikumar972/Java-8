package BiConsumers;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String,String> b1= String::equalsIgnoreCase;
        BiPredicate<String,String> b2=(s1,s2)->s1.length()==s2.length();
        System.out.println(b2.and(b1).test("sai","SAI"));
        System.out.println(b2.or(b1).test("sai","ias"));
    }
}

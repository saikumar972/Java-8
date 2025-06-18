package dumps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAString {
    public static void main(String[] args) {
        String s="someone greets you";
        System.out.println("------------NORMAL REVERSE------------");
        String reverse=new StringBuilder(s).reverse().toString();
        System.out.println(reverse);
        System.out.println("------------ONLY WORD SEQUENCE REVERSE------------");
        //for more space issue we use regex command \\s+
        String collect = Arrays.stream(s.split("\\s+"))
                .map(k -> new StringBuilder(k).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect);
        System.out.println("--------REVERSE SORTED ORDER----------------");
        Arrays.stream(s.split(" "))
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("--------REVERSE ORDER----------------");
        String s1="someone greets you";
       String[] reverseString=s1.split(" ");
       IntStream.rangeClosed(0,reverseString.length-1)
               .forEach(ss-> System.out.println(reverseString[reverseString.length-(1+ss)]));
       System.out.println("--------REVERSE ORDER----------------");
        String s2="someone greets you";
        String collect1 = Arrays.asList(s2.split(" ")).reversed().stream().collect(Collectors.joining(" "));
        System.out.println(collect1);
    }
}

package dumps;

import java.util.Arrays;

public class VowelsAndConsonentsCount {
    public static void main(String[] args) {
        String k="AEIOUSDUIFEKJD";
        System.out.println(k.length());
        long count = Arrays.stream(k.split(""))
                .filter(c -> c.matches("[AEIOUaeiou]+"))
                .count();
        System.out.println("Vowels are "+count);
        Long consonents=k.length()-count;
        System.out.println("Consonents are "+consonents);
    }
}

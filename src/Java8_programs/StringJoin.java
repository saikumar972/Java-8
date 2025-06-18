package Java8_programs;

import java.util.Arrays;
import java.util.List;

public class StringJoin {
    public static void main(String[] args) {
        List<String> k= Arrays.asList("sds","af","sdfdf");
        String k1=String.join("-",k);
        System.out.println(k1);
    }
}

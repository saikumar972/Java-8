package Java8_programs;

import java.util.Arrays;
import java.util.Comparator;

public class LongestString {
    public static void main(String[] args) {
        String[] s={"aaf","adafsdsdg","sdgsdg"};
        String k= Arrays.stream(s)
                .reduce((o1,o2)->o1.length()>o2.length()?o1:o2).get();
        System.out.println(k);
    }
}

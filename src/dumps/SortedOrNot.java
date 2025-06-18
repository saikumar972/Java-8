package dumps;

import java.util.stream.IntStream;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr={1,34,45,132,167};
        boolean b = IntStream.range(0, arr.length-1)
                .allMatch(size -> arr[size] <= arr[size + 1]);
        System.out.println(b);
    }
}

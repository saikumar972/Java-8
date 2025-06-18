package dumps;

import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        int k=30;
        boolean b = IntStream.rangeClosed(2, (int) Math.sqrt((double) k))
                .noneMatch(i -> k % i == 0);
        System.out.println("Prime or not "+b);

    }
}

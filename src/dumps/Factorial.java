package dumps;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    private static int fact=1;
    public static void main(String[] args) {
        Integer k=12;
        Integer k2=500;
        Long factorial= LongStream
                .rangeClosed(1,k)
                .reduce(1,(a,b)->a*b);
        System.out.println(factorial);
        System.out.println("------------------------------------------------------------");
        BigInteger factorial2= LongStream
                .rangeClosed(1,k2)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE,BigInteger::multiply);
        System.out.println(factorial2);
        System.out.println("------------------------------------------------------------");
        int k3=5;
        AtomicInteger factorial3= new AtomicInteger(1);
        IntStream.rangeClosed(1,k3)
                .forEach(i->{
                    factorial3.set(factorial3.get() * i);
                });
        System.out.println(factorial3.get());
        System.out.println("------------------------------------------------------------");
        int k4=5;
        IntStream.rangeClosed(1,k3)
                .forEach(i->{
                    fact*=i;
                });
        System.out.println(fact);
    }
}

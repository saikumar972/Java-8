package dateAndTime.datesandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Durations {
    public static void main(String[] args) {
        //duration in seconds
        Instant now = Instant.now();
        for(int i=0;i<1000000000;i++){
            //ntg
        }
        Instant now2 =Instant.now();
        //duration b/w two of them
        Duration between = Duration.between(now, now2);
        System.out.println(between);
        //of
        //PT = A period of time.
        //0.001S = 0.001 seconds (i.e., 1 millisecond).
        Duration between2 = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(between2);
        System.out.println(between2.toMillis()+" ms");
        System.out.println(between2.toDays()+" days");
        //comparison od two durTIONS
        int i = between.compareTo(between2);
        System.out.println(i);
    }
}

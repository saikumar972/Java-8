package dateAndTime.datesandtime;

import java.time.LocalDateTime;

public class LocalDateAndTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //get hour
        int hour = now.getHour();
        System.out.println(hour);
        //of
        LocalDateTime random = LocalDateTime.of(1999, 8, 12, 05, 12, 12, 12222);
        System.out.println(random);
        //parse
        String randomDateTime="1999-08-12T05:12:12.12345";
        LocalDateTime parse = LocalDateTime.parse(randomDateTime);
        System.out.println(parse);
    }
}

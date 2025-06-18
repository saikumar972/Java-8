package dateAndTime.datesandtime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Instantt {
    public static void main(String[] args) {
        //used for machine time stamps
        //try epoch  converter for human readable format
        long k=System.currentTimeMillis();
        System.out.println(k);
        //using instant getting date time
        Instant now = Instant.now();
        System.out.println(now);
        //Instant to Zoned
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Calcutta"));
        System.out.println(zonedDateTime);
        //Zoned to Instant
        Instant instant = ZonedDateTime.now().toInstant();
        System.out.println(instant);
    }
}

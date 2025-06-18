package dateAndTime.datesandtime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneDateTime {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        //want present new york time
        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(now1);
        //set of available time zones
        //todo parse and of
        Set<String> zones= ZoneId.getAvailableZoneIds();
        //zones.forEach(System.out::println);
    }
}

package dateAndTime.datesandtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoUnit;

public class PeriodTopic {
    public static void main(String[] args) {
        LocalDate date1=LocalDate.now();
        LocalDate date2=LocalDate.of(1999,8,12);
        Period between = Period.between(date2, date1);
        System.out.println(between);
        //to get years
        int years = between.getYears();
        System.out.println(years);

        //to get number of days
        long between1 = ChronoUnit.DAYS.between(date2, date1);
        System.out.println(between1);
    }
}

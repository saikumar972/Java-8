package dateAndTime.datesandtime;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Localdatee {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        //random date
        LocalDate date2 = LocalDate.of(1999, 8, 12);
        System.out.println(date2);
        //get month
        Month month = date2.getMonth();
        System.out.println(month);
        System.out.println(month.toString());//to get month in string
        //get month value
        int monthValue = date2.getMonthValue();
        System.out.println(monthValue);
        //get day
        int dayOfMonth = date2.getDayOfMonth();
        System.out.println(dayOfMonth);
        //getting year
        int year = date2.getYear();
        System.out.println(year);
        //adding years
        LocalDate localDate = date2.plusYears(25);
        System.out.println(localDate);
        //comparing two dates
        System.out.println(date.compareTo(date2));
        //parsing String as date
        String datee="2024-01-01";
        LocalDate localDate1=LocalDate.parse(datee);
        System.out.println(localDate1);
        //formatting date
        String formatDate="08/12/1999";
        DateTimeFormatter format=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(LocalDate.parse(formatDate,format));
        String format1 = date.format(format);
        System.out.println(format1);
        //year leap or not
        String leap="2000";
        Year y=Year.parse(leap);
        if(y.isLeap()){
            System.out.println("leap year");
        }
        else{
            System.out.println("no");
        }
        //to do is After and isBefore
    }
}

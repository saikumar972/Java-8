package dateAndTime.datesandtime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatting {
    public static void main(String[] args) {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date="12/08/1999";
        LocalDate parse = LocalDate.parse(date, format);
        System.out.println(parse);
        //date to format
        LocalDate localDate = LocalDate.of(1999, 8, 12);
        String format1 = localDate.format(format);
        System.out.println(format1);
        //in simple
        LocalDate d=LocalDate.parse("12/12/2012",format);
        System.out.println(d);
        //todo in yyyy/MM/dd HH:mm:ss z
    }
}

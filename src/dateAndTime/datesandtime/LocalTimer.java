package dateAndTime.datesandtime;

import java.time.LocalTime;

public class LocalTimer {
    public static void main(String[] args){
        LocalTime now = LocalTime.now();
        System.out.println(now);
        //random time 923951300
        LocalTime random = LocalTime.of(10, 54, 21, 900);
        System.out.println(random);
        //string input
        String input="11:22:59.90887789";
        LocalTime parse = LocalTime.parse(input);
        System.out.println(parse);
        //get seconds
        System.out.println(now.getSecond());
        //adding minutes
        LocalTime addminutes = parse.plusMinutes(69);
        System.out.println(addminutes);
        //to do isAfter and isBefore
    }
}

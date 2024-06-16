package Utilities;

import java.time.*;
import java.time.format.DateTimeFormatter;
//import java.time.temporal.*;
import java.time.temporal.ChronoUnit;

//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/temporal/ChronoUnit.html

// Dates and Times

/* Java 8 provided much needed improvements in this area with the
 addition of the java.time package. We will explore this new package, but you will
 still encounter many, many Date and Calendar examples in the wild, so it’s useful to
 know they exist */
public class Datestime {
    
    public static void main(String [] arg){

    /* Local Dates and Times
    The java.time.LocalDate class represents a date without time information for your
    local region. Think of a holiday such as May 4, 2019. Similarly, java.time.LocalTime
    represents a time without any date information. Perhaps your alarm clock goes off at
    7:15 every morning. The java.time.LocalDateTime stores both date and time values
    for things like appointments with your eye doctor so you can keep reading books on
    Java. All of these classes offer static methods for creating new instances using either
    appropriate numeric values with of() or by parsing strings with parse(). Let’s pop
    into jshell and try creating a few examples. */
  String date = "2019 5 4";
        String[] format = date.split("\\s");

        // Parse year, month, and day from the split array
        int year = Integer.parseInt(format[0]);
        int month = Integer.parseInt(format[1]);
        int day = Integer.parseInt(format[2]);

        // Create a LocalDate object
        LocalDate value2 = LocalDate.of(year, month, day);
         // Print the parsed LocalDate
         System.out.println("Parsed LocalDate: " + value2);
        LocalTime currentT = LocalTime.now();
        LocalDate currentD = LocalDate.now();

        LocalDateTime currentTD = LocalDateTime.now();

        
        System.out.println(currentD);
        System.out.println(currentT);
        System.out.println(currentTD);
       

        LocalDateTime first = LocalDateTime.now();
        LocalDateTime second = LocalDateTime.now();

        long new1 = ChronoUnit.SECONDS.between(first, second);
        System.out.println("Seconds between " + first + " and " + second + ": " + new1);


        /* Those units can also help you manipulate dates and times with the plus() and
        minus() methods. To set a reminder for one week from today, for example:
        */
        LocalDate remainder = currentD.plus(2, ChronoUnit.WEEKS);
        System.out.println(remainder);

        // LocalTime reminder = LocalTime.now();
       
        /*You can convert between dates or times and date-times easily enough
        with the atDate() or atTime() methods:
        */
        LocalDateTime betterReminder = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0));
        System.out.println(betterReminder);


        // Time Zones
        /*The zoned variant understands named time zones and things like day
        light saving adjustments. The offset variant is a constant, simple numeric offset from
        UTC/Greenwich Most user-facing uses of dates and times will use the named zone approach, so let’s
        look at creating a zoned date-time. To attach a zone, we use the ZoneId class, which
        has the common of() static method for creating new instances. You can supply a
        region zone as a String to get your zoned value:
        */

        LocalDateTime piLocal = LocalDateTime.parse("2019-03-14T01:59");
        ZonedDateTime picentral = piLocal.atZone(ZoneId.of("America/Chicago"));


        /*Most user-facing uses of dates and times will use the named zone approach, so let’s
        look at creating a zoned date-time. To attach a zone, we use the ZoneId class, which
        has the common of() static method for creating new instances. You can supply a
        region zone as a String to get your zoned value:
        */
        ZonedDateTime piAlaMode = picentral.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println(piAlaMode);
        // piAlaMode = piLocal.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        // System.out.println(piAlaMode);

        /* If you have other friends who aren’t conveniently located in a major metropolitan
        region but you want them to join as well, you can use the systemDefault() method
        of ZoneId to pick up their time zone programmatically:
        */
         ZonedDateTime piOther = piAlaMode.withZoneSameInstant(ZoneId.systemDefault());
         System.out.println(piOther);

         /*
          * y
          * M
          * L
          * d
          * E
          * a
          * h
          * K
          * k
          * H
          * m
          * s
          * S
          * z
          * Z
          * year-of-era
          * month-of-year
          * month-of-year
          * day-of-month
          * day-of-week
          * am-pm-of-day
          * 2004; 04
          * 7; 07
          * Jul; July; J
          * 10
          * Tue; Tuesday; T
          * PM
          * clock-hour-of-am-pm (1-12) 12
          * hour-of-am-pm (0-11)
          * clock-hour-of-day (1-24)
          * hour-of-day (0-23)
          * minute-of-hour
          * second-of-minute
          * fraction-of-second
          * time-zone name
          * zone-offset
          * 0
          * 24
          * 0
          * 30
          * 55
          * 033954
          * Pacific Standard Time; PST
          * +0000; -0800; -08:00
          */
         DateTimeFormatter shortUS = DateTimeFormatter.ofPattern("MM/dd/yy");

         LocalDate valentines = LocalDate.parse("02/14/19", shortUS);
         LocalDate piDay = LocalDate.parse("03/14/19", shortUS);

         // Timestamps

         /*In any situation where tracking the flow of information is required, you’ll
         need a record of exactly when the information is produced or modified. You will still
         see the java.util.Date class used to store these moments in time, but the
         java.time.Instant class carries everything you need for a timestamp and comes
         with all the other benefits of the other classes in the java.time package
         */

         Instant time1 = Instant.now();
         Instant time2 = Instant.now();
         System.out.println(time1 + "\n" + time2);
         

         boolean time3 = time1.isAfter(time2);  //false
         System.out.println(time3);
         time3 = time2.isAfter(time1);  // false
         System.out.println(time3);
         Instant time4 = time1.plus(3, ChronoUnit.DAYS);
         System.out.println(time4);
         time3 = time4.isAfter(time2);  //true
         System.out.println(time3);
         System.out.println(piDay+"\n"+valentines);

           







       
    }
}

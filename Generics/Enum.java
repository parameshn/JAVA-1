package Generics;

import java.util.*;


enum Days {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAYA,FRIDAY,SATURDAY,SUNDAY
 }


 public class Enum {
     public static void main(String main[]) {
         EnumSet<Days> weekend = EnumSet.of(Days.SATURDAY, Days.SUNDAY);

         System.out.println("Weekebd days :" + weekend);

         EnumSet<Days> alldays = EnumSet.allOf(Days.class);
         System.out.println("All days:" + alldays);

         EnumSet<Days> noDays = EnumSet.noneOf(Days.class);
         System.out.println("Empty EnumSet:" + noDays);

         EnumSet<Days> workDays = EnumSet.complementOf(EnumSet.of(Days.SATURDAY, Days.SUNDAY));
         System.out.println("Workdays:" + workDays);
     }

 }

 /*
  * EnumSet.of(...): Allows you to include specific enum values.
  * EnumSet.allOf(...): Includes all the enum values.
  * EnumSet.noneOf(...): Starts as an empty set.
  * EnumSet.complementOf(...): Includes all values except the ones specified.
  */

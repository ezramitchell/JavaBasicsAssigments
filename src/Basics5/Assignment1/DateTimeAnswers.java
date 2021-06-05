package Basics5.Assignment1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAnswers {
    /*
     Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
    LocalDateTime
 Given a random date, how would you find the date of the previous Thursday?
    LocalDate now = new LocalDate().now();
    int currentDay = now.getDayOfWeek().getValue();
    int th = DayOfWeek.THURSDAY.getValue();
    int offset = currentDay < th ? (currentDay + 7) - th : currentDay - th;
    now.minusDays(offset);

 What is the difference between a ZoneId and a ZoneOffset?
    ZoneId works with instants and ZoneOffset works with time zones
 How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
    intstant.atZone(zoneID), zonedDateTime.toInstant()

 Write an example that, for a given year, reports the length of each month within that year.
    printMonths();
 Write an example that, for a given month of the current year, lists all of the Mondays in that month.
    printMondays();
 Write an example that tests whether a given date occurs on Friday the 13th.
     */
    public static void main(String[] args) {
        printMonths(2000);
        printMondays(4);
        System.out.println(isFriday13(LocalDate.parse("2018-07-13")));
    }

    public static void printMonths(int year){
        for(int i = 1; i <= 12; i++){
            YearMonth ym = YearMonth.of(year, i);
            System.out.printf("%s has %s days in %s %n", ym.getMonth(), ym.lengthOfMonth(), year);
        }
    }

    public static void printMondays(int month){
        LocalDate current = LocalDate.now(ZoneId.of("America/Denver")).withMonth(Math.max(1, Math.min(12, month)));
        LocalDate firstMonday = current.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.printf("There are %s Mondays in %s %n", (current.lengthOfMonth() - firstMonday.getDayOfMonth()) / 7 + 1, current.getMonth());
    }

    public static boolean isFriday13(LocalDate day){
        return day.getDayOfMonth() == 13 && day.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

}

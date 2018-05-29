import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class Chapter12_Demo_2_DateTimeAPI {

    public static void main(String[] args){

        System.out.println("Lets Start");

        LocalDateTime localDateTime2 = LocalDateTime.of(1991,02,11,17,05,05);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd//MM/yyyy");

        String date = localDateTime2.format(dtf);

        System.out.println("Formatted date: "+date);

        LocalDate localDate = LocalDate.parse(date, dtf);

        System.out.println("Parsed date: "+localDate);


        LocalDate localDate1 = LocalDate.parse("1991-02-11", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("ISO Local Date date: "+localDate1);

        //Adjuster (modifying date using adjustor)
        //TemporalAdjusters provides various static methods to modify dates

        localDate = LocalDate.of(2018, 03, 31);
        LocalDate date1 = localDate.with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("date: "+localDate);
        System.out.println("Adjusteres date: "+date1);

        //Custom TemporalAdjusters
        //Find Next Working Day
        LocalDate date2 = LocalDate.now();

        TemporalAdjuster customAdjusterNextWorkingDay = TemporalAdjusters.ofDateAdjuster(
            e->{
                DayOfWeek dow= DayOfWeek.of(e.get(ChronoField.DAY_OF_WEEK));
                System.out.println("DayOf week:"+dow);
                int dayToAdd = 1;
                if (dow == DayOfWeek.FRIDAY) dayToAdd=3;
                if (dow == DayOfWeek.SATURDAY) dayToAdd=2;
                if (dow == DayOfWeek.SUNDAY) dayToAdd=1;
                return e.plus(dayToAdd, ChronoUnit.DAYS);
            });

        date2 =  localDate.with(customAdjusterNextWorkingDay);
        System.out.println("Next Working Day: "+date2);

       date2 = localDate.with(e->{
            DayOfWeek dow = DayOfWeek.of(e.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd=3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd=2;
            if (dow == DayOfWeek.SUNDAY) dayToAdd=1;
            return e.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println("Next Working Day: "+date2);
    }
}

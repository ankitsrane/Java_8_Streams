import java.time.*;
import java.time.temporal.ChronoField;

public class Chapter12_Demo_1_DateTimeAPI {

    public static void main(String[] args){
        System.out.println("Here comes Date api of Java 8 LocalDate,LocalTime, LocalDateTime");

        //Local Date
        LocalDate localDate1 = LocalDate.of(1991,02,11);
        System.out.println("My DOB: "+localDate1);

        System.out.println("My DOB Day using TemporalField: "+localDate1.get(ChronoField.DAY_OF_MONTH));
        System.out.println("My DOB Day normally: "+localDate1.getDayOfMonth());

        localDate1 = LocalDate.now();
        System.out.println("Current Date: "+localDate1);


        //LocalTime
        LocalTime localTime1 = LocalTime.of(12,01,01);
        System.out.println("Time : "+localTime1);
        System.out.println("Time hour : "+localTime1.getHour());
        System.out.println("Time hour with CronoField: "+localTime1.get(ChronoField.HOUR_OF_DAY));

        localTime1 = LocalTime.now();
        System.out.println("Currrent Time : "+localTime1);


        //Date and Time by Parsing String
        localDate1 = LocalDate.parse("1991-02-11");
        System.out.println("My DOB: "+localDate1);
        localTime1 = LocalTime.parse("17:05:05");
        System.out.println("Time: "+localTime1);

        //LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(1989,03,17,17,05,05);
        System.out.println("LocalDateTime1 : "+localDateTime1);
        System.out.println("LocalDateTime1 : "+localDateTime2);

        LocalDateTime localDateTime3 = localDate1.atTime(localTime1);
        LocalDateTime localDateTime4 = localDate1.atTime(12,05,05);
        LocalDateTime localDateTime5 = localTime1.atDate(localDate1);

        localDate1 = localDateTime5.toLocalDate();
        localTime1 = localDateTime5.toLocalTime();


        //instant  which accept second and nano second from 1st jan 1970 to till date and the seconds which we will provide
        Instant instant = Instant.ofEpochMilli(1000000L);

        //Duration (compare two LocalTime, LocalDateTime and Instant)
        Duration duration1 = Duration.between(localDateTime1, localDateTime2);
        Duration duration2 = Duration.between(localDateTime1.toLocalTime(), localDateTime2.toLocalTime());

        System.out.println("duration1 : "+duration1);
        System.out.println("duration2 : "+duration2.toHours());

        duration1 = Duration.ofDays(3);
        System.out.println("duration1 : "+duration1);

        //Period (Compare Dates)
        Period period = Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate());
        System.out.println("period between dates : "+period);

        period = Period.of(1991,11,02);
        System.out.println("period: "+period);

        //Menupulating Date
        localDate1 = localDate1.withYear(2018);
        System.out.println("Changed Date: "+localDate1);

        //Menupulating Time
        localTime1 = localTime1.plusHours(1);
        System.out.println("Changed Time: "+localTime1);
    }
}

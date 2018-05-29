import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class DateTmeNewApiDEmo {
	
	public static void main(String[] args) throws ParseException {
		LocalDate ld = LocalDate.now();
		
		System.out.println(Period.between(ld, LocalDate.MIN).getDays());
		
		System.out.println(Period.ofDays(6).getDays());
		
		System.out.println(Period.ofYears(1).getDays());
		
		System.out.println("Year: "+Year.parse("2017",DateTimeFormatter.ofPattern("yyyy")));
		
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		DateFormat df = DateFormat.getInstance();
		System.out.println("format: "+df.format(Date.valueOf(ld)));
		
		System.out.println("Format: "+ld.format(dtf));
		
		System.out.println("parse: "+ld.parse("11-02-1991", dtf));
		
	//	System.out.println("Year:"+Year.parse(ld, dtf));
		
		//DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
	}

}

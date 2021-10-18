package ec.advance.latam.com.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		ZoneId zoneId = ZoneId.of("America/Guayaquil");
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
		System.out.println("Date : " + zonedDateTime.getDayOfWeek().getValue());

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		String dateInString = "17-10-2021";
		Date date = formatter.parse(dateInString);
		System.out.println(date);

	}
}

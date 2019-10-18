package src.main.java;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class dateDisplay{

	private static final String startDate = "1986-04-08";
	//SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	public static void displayDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 4);
		System.out.println(cal);
	}

	//String dt = "2008-01-01";  // Start date

	/*Calendar c = Calendar.getInstance();
	c.setTime(sdf.parse(dt));
	c.add(Calendar.DATE, 1);  // number of days to add
	dt = sdf.format(c.getTime()); 
	*/
}
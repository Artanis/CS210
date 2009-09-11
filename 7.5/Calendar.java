/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */


import java.util.GregorianCalendar;

public class Calendar {
	public static void main (String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		
		System.out.println(String.format(
			"Current Date: %s", Calendar.print_date(date)));
		
		long millis = 123456789L;
		date.setTimeInMillis(millis);
		System.out.println(String.format(
			"Date at %d milli-seconds past Unix Epoch: %s",
			millis,
			Calendar.print_date(date)));
	}
	
	/**
	 * Creates a string representing the date in the format specified.
	 * 
	 * @param GregorianCalendar date
	 * 
	 * @return String representation of the date
	 */
	public static String print_date(GregorianCalendar date) {
		return String.format(
			"%d-%d-%d %d:%d:%d.%d",
			date.get(GregorianCalendar.YEAR),
			date.get(GregorianCalendar.MONTH),
			date.get(GregorianCalendar.DAY_OF_MONTH),
			date.get(GregorianCalendar.HOUR),
			date.get(GregorianCalendar.MINUTE),
			date.get(GregorianCalendar.SECOND),
			date.get(GregorianCalendar.MILLISECOND));
	}
}

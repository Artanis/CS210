/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ISBN {
	public static void main (String[] args) {
		boolean console = true;
		
		if (args.length > 0 && args[0].equals("pane")) {
			console = false;
		}
		
		long partial = ISBN.get_isbn(console);
		String isbn = String.format("%09d-%s", partial, ISBN.checksum(partial));
		ISBN.display_isbn(isbn, console);
	}
	
	public static long get_isbn(boolean console) {
		String message = "Enter the first 9 digits of the ISBN";
		
		long input = 0;
		
		if (console) {
			Scanner in = new Scanner(System.in);
			System.out.print(message + ": ");
			input = in.nextLong();
		} else {
			input = Long.parseLong(JOptionPane.showInputDialog(null,
				message, "ISBN",
				JOptionPane.QUESTION_MESSAGE));
		}
		
		return input;
	}
	
	public static void display_isbn(String isbn, boolean console) {
		String output = String.format("The full ISBN is %s", isbn);
		if (console) {
			System.out.println(output);
		} else {
			JOptionPane.showMessageDialog(null, output);
		}
	}
	
	public static String checksum(long isbn) {
		String str_isbn = String.format("%09d",isbn);
		
		int length = str_isbn.length();
		int checksum = 0;
		
		for(int i = 0; i < length; i++) {
			int digit = Integer.parseInt(str_isbn.substring(i, i + 1));
			int multiplier = i + 1;
			
			checksum +=  digit * multiplier;
		}
		
		checksum %= 11;
		
		if(checksum >= 10) {
			return "X";
		} else {
			return String.format("%d", checksum);
		}
	}
}

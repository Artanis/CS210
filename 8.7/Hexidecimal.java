import javax.swing.JOptionPane;

public class Hexidecimal {
	public static void main (String[] args) {
		String valid = "0123456789ABCDEFGabcdefg";
		
		for (int i = 0; i < valid.length(); i++) {
			System.out.println(String.format(
				"%s %d %b", valid.charAt(i), (int) valid.charAt(i),
				Hexidecimal.valid_digit(valid.charAt(i))));
		}
	}
	
	/**
	 * Parses a hexidecimal string into an integer
	 *
	 * @return int
	 */
	public static int parseHex(String hex) {
		return 0;
	}
	
	/**
	 * Retrieves a hexidecimal string from the user
	 * 
	 * @return String
	 */
	public static String get_hexstring() {
		return new String();
	}
	
	/**
	 * Validates provided digit is in Hexidecimal space
	 * 
	 * @param char hex Digit to check
	 * 
	 * @return boolean valid
	 */
	public static boolean valid_digit(char hex) {
		// Takes advantage of the char type's other form as a normal
		// integer to quickly set bounds on valid contents.
		return (((hex >= '0') && (hex <= '9')) ||
			((hex >= 'a') && (hex <= 'f')) ||
			((hex >= 'A') && (hex <= 'F')));
	}
}

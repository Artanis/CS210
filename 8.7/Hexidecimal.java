import javax.swing.JOptionPane;

public class Hexidecimal {
	public static void main (String[] args) {
		String hex = Hexidecimal.get_hexstring();
		
		int decimal = Hexidecimal.parseHex(hex);
		
		JOptionPane.showMessageDialog(null, String.format(
			"0x%s is decimal %d", hex, decimal));
	}
	
	/**
	 * Parses a hexidecimal string into an integer
	 *
	 * @return int
	 */
	public static int parseHex(String hex) {
		int magnitude = hex.length()-1;
		
		int decimal = 0;
		
		for (int i = magnitude; i >= 0; i--) {
			int digit = Hexidecimal.convert_digit(hex.charAt(i));
			int place = magnitude-i;
			
			//System.out.println(String.format("%s=%d",hex.charAt(i),
				//digit));
			//System.out.println(String.format("  digit = %d * 16^%d",
			//	digit, place));
			//System.out.println(String.format("  digit = %d * %d",
			//	digit, (int)Math.pow(16,place)));
			//System.out.println(String.format("  digit = %d",
			//	(int)(digit * Math.pow(16,place))));
			
			decimal += (int)(digit * Math.pow(16, place));
		}
		
		return decimal;
	}
	
	/**
	 * Retrieves a hexidecimal string from the user
	 * 
	 * @return String
	 */
	public static String get_hexstring() {
		String hex_string = JOptionPane.showInputDialog(null,
			"Enter a hexidecimal integer", "Hexidecimal -> Decimal",
			JOptionPane.QUESTION_MESSAGE);
		
		if(Hexidecimal.validate(hex_string)) {
			return hex_string;
		} else {
			JOptionPane.showMessageDialog(null, String.format(
				"Invalid hexidecimal integer \"0x%s\"", hex_string));
		}
		
		return new String();
	}
	
	public static int convert_digit(char hex) {
		int value = 0;
		if (hex <= '9') {
			value = hex - '0';
		} else if(hex <= 'F') {
			value = hex - 'A' + 10;
		} else if(hex <= 'f') {
			value = hex - 'a' + 10;
		}
		return value;
	}
	
	/**
	 * Checks that the hex string is valid
	 *
	 * @param String hex
	 * 
	 * @return boolean
	 */
	public static boolean validate(String hex) {
		for (int i = 0; i < hex.length(); i++) {
			if(!Hexidecimal.valid_digit(hex.charAt(i))) {
				return false;
			}
		}
		
		return true;
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

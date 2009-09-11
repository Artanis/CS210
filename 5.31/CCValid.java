/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import javax.swing.JOptionPane;

public class CCValid {
	public static void main (String[] args) {
		long number = Long.parseLong(
			JOptionPane.showInputDialog(null,
				"Enter Credit Card Number", "Validate Credit Card",
				JOptionPane.QUESTION_MESSAGE));
		
		String output = CCValid.isValid(number) ?
			"Number is valid":
			"Number is not valid";
		
		JOptionPane.showMessageDialog(null, output);
	}
	/**
	 * Return true if the card number is valid.
	 * 
	 */
	public static boolean isValid(long number) {
		int step2 = CCValid.sumOfEvenPlace(number);
		//System.out.println(String.format("Step 2 %d", step2));
		
		int step3 = CCValid.sumOfOddPlace(number);
		//System.out.println(String.format("Step 3 %d", step3));
		
		int step4 = step2 + step3;
		//System.out.println(String.format("Step 4 %d", step4));
		
		boolean step5 = (step4 % 10) == 0;
		//System.out.println(String.format("Step 5 %d", step4 % 10));
		
		return step5;
	}
	
	/**
	 * Get the result of Step 2:
	 * 
	 */
	public static int sumOfEvenPlace(long number) {
		String str_number = String.format("%d", number);
		
		int length = str_number.length();
		
		int step2 = 0;
		
		//System.out.println("Step 1");
		
		for (int i = 0; i < length; i = i + 2) {
			int digit = Integer.parseInt(str_number.substring(i, i+1));
			//System.out.println(String.format("   Digit: %d", digit));
			int step1 = 2 * digit;
			//System.out.println(String.format("   Double: %d", step1));
			step1 = CCValid.getDigit(step1);
			step2 = step2 + step1;
			//System.out.println(String.format("   Sum: %d", step2));
		}
		
		return step2;
	}
	
	/**
	 * Return this number if it is a single digit, otherwise return the
	 * sum of the two digits
	 * 
	 */
	public static int getDigit(int number) {
		if (number >= 10) {
			String str_number = String.format("%d", number);
			int result = Integer.parseInt(str_number.substring(0,1)) + 
				Integer.parseInt(str_number.substring(1,2));
			
			//System.out.println(String.format("       Add: %d", result));
			
			return result;
		}
		
		return number;
	}
	
	/**
	 * Return the sum of odd place digits in number
	 * 
	 */
	public static int sumOfOddPlace(long number) {
		String str_number = String.format("%d", number);
		
		int length = str_number.length();
		
		int step3 = 0;
		
		//System.out.println("Step 3");
		
		for (int i = 1; i < length; i = i + 2) {
			int digit = Integer.parseInt(str_number.substring(i, i+1));
			//System.out.println(String.format("    Adding: %d", digit));
			step3 = step3 + digit;
			//System.out.println(String.format("    Sum: %d", step3));
		}
		
		return step3;
	}
}

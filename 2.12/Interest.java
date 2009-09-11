/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Interest {
	/**
	 * Main Application
	 *
	 * CLI Arguments
	 *     text -- use text based input (default)
	 *     pane -- use JOptionPane
	 * 
	 * @param String[] args
	 *
	 */
	public static void main (String[] args) {
		boolean console = true;
		
		if (args.length > 0 && args[0].equals("pane")) {
			console = false;
		}
		
		float balance = Interest.get_balance(console);
		float rate = Interest.get_rate(console);
		
		float interest_payment = Interest.interest_payment(balance, rate);
		
		Interest.display_result(interest_payment, console);
	}
	
	public static float get_rate() {
		return Interest.get_rate(true);
	}
	/**
	 * Requests loan interest rate from the user
	 *
	 * @param boolean console Console or JOptionPane input (default Console)
	 * 
	 * @return float loan interest rate
	 */
	public static float get_rate(boolean console) {
		String dialog = "Enter Loan Annual Interest Rate";
		float input = 0;
		
		if (console) {
			Scanner input_ = new Scanner(System.in);
			System.out.print(dialog + ": %");
			input = input_.nextFloat();
		} else {
			input = Float.parseFloat(JOptionPane.showInputDialog(null, dialog,
				"Calculate Interest",
				JOptionPane.QUESTION_MESSAGE));
		}
		
		return input;
	}
	
	public static float get_balance() {
		return Interest.get_balance(true);
	}
	
	/**
	 * Requests loan interest rate from the user
	 *
	 * @param boolean console Console or JOptionPane input (default Console)
	 * 
	 * @return float loan balance
	 */
	public static float get_balance(boolean console) {
		String dialog = "Enter Loan Balance";
		float input = 0;
		if (console) {
			Scanner input_ = new Scanner(System.in);
			System.out.print(dialog + ": $");
			input = input_.nextFloat();
		} else {
			input = Float.parseFloat(JOptionPane.showInputDialog(null, dialog,
				"Calculate Interest",
				JOptionPane.QUESTION_MESSAGE));
		}
		
		return input;
	}
	
	/**
	 * Calculates next month's interest
	 *
	 * @param float balance Loan balance
	 * @param float rate Loan interest rate
	 * 
	 * @return float interest payment
	 */
	public static float interest_payment(float balance, float rate) {
		return balance * (rate / 1200);
	}
	
	public static void display_result(float payment) {
		Interest.display_result(payment, true);
	}
	
	/**
	 * Displays interest payment
	 *
	 * @param float payment Interest payment
	 * @param boolean console Console or JOptionPane output (default Console)
	 */
	public static void display_result(float payment, boolean console) {
		String output = String.format(
			"The next monthly payment is $%1.2f",
			(int)(payment * 100) / 100.0);
		
		if (console) {
			System.out.println(output);
		} else {
			JOptionPane.showMessageDialog(null, output);
		}
	}
}

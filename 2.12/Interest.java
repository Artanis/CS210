import javax.swing.JOptionPane;

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
		
		if (args[0].equals("pane")) {
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
		String input = "0";
		if (console) {
			
		} else {
			input = JOptionPane.showInputDialog(null,
				"Enter Loan Annual Interest Rate",
				"Calculate Interest",
				JOptionPane.QUESTION_MESSAGE);
		}
		
		return Float.parseFloat(input);
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
		String input = "0";
		if (console) {
		} else {
			input = JOptionPane.showInputDialog(null,
				"Enter Loan Balance",
				"Calculate Interest",
				JOptionPane.QUESTION_MESSAGE);
		}
		
		return Float.parseFloat(input);
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

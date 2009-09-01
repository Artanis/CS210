import java.util.Scanner;
import javax.swing.JOptionPane;

public class Payroll {
	
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
		
		String query_name    = "Employee's name";
		String query_hours   = "Hours worked in week";
		String query_payrate = "Hourly Pay";
		String query_fed_withold = "Federal tax witholding rate";
		String query_state_withold = "State tax witholding rate";
		
		String employee_name = Payroll.get_string(query_name, console);
		float hours_per_week = Payroll.get_float(query_hours, console);
		float payrate = Payroll.get_float(query_payrate, console);
		float fed_withold = Payroll.get_float(query_fed_withold, console);
		float state_withold = Payroll.get_float(query_state_withold, console);
		
		Payroll.display_payroll(employee_name, hours_per_week, payrate,
			fed_withold, state_withold, console);
	}
	
	public static String get_string(String message, boolean console) {
		String input = "";
		
		if (console) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter " + message + ": ");
			input = scan.next();
		} else {
			input = JOptionPane.showInputDialog(null, "Enter" + message,
				"Payroll",JOptionPane.QUESTION_MESSAGE);
		}
		
		return input;
	}
	
	public static float get_float(String message, boolean console) {
		float input = 0;
		
		if (console) {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter " + message + ": ");
			input = in.nextFloat();
		} else {
			input = Float.parseFloat(JOptionPane.showInputDialog(null,
				"Enter" + message, "Payroll",
				JOptionPane.QUESTION_MESSAGE));
		}
		
		return input;
	}
	
	public static void display_payroll(String name, float hours,
		float payrate, float fed_withold, float state_withold,
		boolean console)
	{
		float gross_pay = payrate * hours;
		float fed_witholding = gross_pay * fed_withold;
		float state_witholding = gross_pay * state_withold;
		
		String output = String.format(
		"Employee Name: %s\n" +
		"Hours Worked: %1.2f\n" + 
		"Pay rate: $%1.2f\n" +
		"Gross pay: $%1.2f\n" +
		"Deductions:\n" +
		"    Federal tax witholding (%1.2f%%): $%1.2f\n" +
		"    State tax witholding (%1.2f%%): $%1.2f\n" +
		"    Total Deductions (%1.2f%%): $%1.2f\n" +
		"Net pay: $%1.2f\n",
		name, hours, payrate, gross_pay, fed_withold * 100,
		fed_witholding, state_withold * 100, state_witholding,
		(fed_withold + state_withold) * 100,
		fed_witholding + state_witholding,
		gross_pay - fed_witholding - state_witholding);
		
		if (console) {
			System.out.println(output);
		} else {
			JOptionPane.showMessageDialog(null, output);
		}
	}
}

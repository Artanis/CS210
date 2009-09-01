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
		
		
		System.out.println(String.format("Employee Name: %s", name));
		System.out.println(String.format("Hours Worked: %1.2f", hours));
		System.out.println(String.format("Pay rate: $%1.2f", payrate));
		System.out.println(String.format("Gross pay: $%1.2f", gross_pay));
		System.out.println("Deductions:");
		System.out.println(String.format(
			"    Federal tax witholding (%1.2f%%): $%1.2f",
			fed_withold * 100, fed_witholding));
		System.out.println(String.format(
			"    State tax witholding (%1.2f%%): $%1.2f",
			state_withold * 100, state_witholding));
		System.out.println(String.format(
			"    Total Deductions (%1.2f%%): $%1.2f",
			(state_withold + fed_withold) * 100,
			fed_witholding + state_witholding));
		System.out.println(String.format("Net pay: $%1.2f",
			gross_pay - fed_witholding - state_witholding));
	}
}

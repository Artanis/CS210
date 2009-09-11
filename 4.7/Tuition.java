/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import javax.swing.JOptionPane;

public class Tuition {
	public static void main (String[] args) {
		int tuition = (int)(Float.parseFloat(JOptionPane.showInputDialog(
			null, "Enter Current Tution", "Tuition",
			JOptionPane.QUESTION_MESSAGE)) * 100);
		
		int progression = Integer.parseInt(JOptionPane.showInputDialog(
			null, "Enter yearly increase percentage (0-100)",
			"Tuition", JOptionPane.QUESTION_MESSAGE));
		int years = Integer.parseInt(JOptionPane.showInputDialog(null,
			"Enter years in the future to calculate", "Tuition",
			JOptionPane.QUESTION_MESSAGE));
		int attendance = 4;
		
		int future_tuition = Tuition.calculate_tuition(
			tuition, progression, years);
		
		int attendance_cost = Tuition.calculate_cost(
			future_tuition, progression, attendance);
		
		String output = String.format(
			"$%1.2f tuition in %d years at %1.2f%% " +
			"increase per year: $%1.2f\n\n" +
			"Total cost of the %d years after that: $%1.2f",
			tuition / 100.0, years, (float)progression,
			future_tuition / 100.0, attendance,
			attendance_cost / 100.0);
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	/**
	 * Calculates the tuition at the end of the number of years at the
	 * progression rate provided.
	 *
	 * @param integer tuition The initial tuition amount in cents
	 * @param integer progression The percentage the tuition
	 *     changes per year
	 * @param integer years The number of years to calculate
	 *
	 * @return integer The future tuition in cents
	 */
	public static int calculate_tuition(int tuition, int progression,
		int years)
	{
		float result = tuition;
		for (int i = 0; i < years; i++) {
			result += result * (progression / 100.0);
		}
		
		return (int)result;
	}
	
	public static int calculate_cost(int tuition, int progression,
		int years)
	{
		float result = tuition;
		
		for (int i = 0; i < years; i++) {
			result += Tuition.calculate_tuition((int)result, progression, 1);
		}
		
		return (int)result;
	}
}

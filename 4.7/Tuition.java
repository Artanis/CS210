public class Tuition {
	public static void main (String[] args) {
		if(args.length >= 3) {
			int tuition = Integer.parseInt(args[0]);
			int progression = Integer.parseInt(args[1]);
			int years = Integer.parseInt(args[2]);
			int attendance = 4;
			
			int future_tuition = Tuition.calculate_tuition(
				tuition, progression, years);
			
			int attendance_cost = Tuition.calculate_cost(
				future_tuition, progression, attendance);
			
			System.out.println(String.format(
				"$%1.2f tuition in %d years at %1.2f%% " +
				"change per year: $%1.2f",
				tuition / 100.0, years, progression / 100.0,
				future_tuition / 100.0));
			
			System.out.println(String.format(
				"Total tuition cost in the %d years after that: $%1.2f",
				attendance, attendance_cost / 100.0));
			
		} else {
			System.out.println("Use: java Tuition " +
				"(int tuition in cents) (int percentage change) " +
				"(int years)");
		}
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

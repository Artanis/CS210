public class Tuition {
	public static void main (String[] args) {
		System.out.println(Tuition.calculate_tuition(
			Integer.parseInt(args[0]),
			Integer.parseInt(args[1]),
			Integer.parseInt(args[2])));
		
		
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
	 & @return integer The new tuition
	 */
	public static float calculate_tuition(int tuition,
		int progression, int years)
	{
		
		for (int i = 0; i < years; i++) {
			tuition *= (progression / 100);
		}
	}
	
	return tuition;
}

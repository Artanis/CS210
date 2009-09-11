public class Pattern {
	/**
	 * Main Application
	 *
	 */
	public static void main(String[] args) {
		System.out.println(Pattern.pattern());
	}
	
	/**
	 * Returns a string containing the text JAVA in a large pattern
	 * 
	 * @return String pattern
	 */
	public static String pattern() {
		String pattern =
		"     J     A    V     V    A    \n" +
		"     J    A A    V   V    A A   \n" +
		" J   J   AAAAA    V V    AAAAA  \n" +
		"  J J   A     A    V    A     A \n";
		
		return pattern;
	}
}

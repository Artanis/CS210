class Matrix {
	public static void main(String[] args) {
		int[][] a =
			{{1, 2, 3},
			 {4, 5, 6},
			 {7, 8, 9}};
		int [][] b = 
			{{9, 8, 7},
			 {6, 5, 4},
			 {3, 2, 1}};
		
		int [][] c = Matrix.multiplyMatrix(a, b);
		
		System.out.println(Matrix.print(c));
	}
	
	public static int rows(int[][] a) {
		return a.length;
	}
	
	public static int cols(int[][] a) {
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(count != 0 && a[i].length != count) {
				return -1;
			} else {
				count = a[i].length;
			}
		}
		return count;
	}
	
	public static String print(int[][] a) {
		String output = "[";
		for (int i = 0; i < a.length; i++) {
			output += "[";
			for (int j = 0; j < a[i].length; j++) {
				output += a[i][j]+" ";
			}
			output += "]";
		}
		output += "]\n";
		return output;
	}
	
	public static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int a_cols = Matrix.cols(a);
		int a_rows = Matrix.rows(a);
		int b_cols = Matrix.cols(b);
		int b_rows = Matrix.rows(b);
		
		// Confirm a's cols = b's rows
		if (a_cols == b_rows) {
			int[][] c = {{1}};
			//int[a_rows][b_cols] c;
			
			// Using the naive algorithm at O(n^3) time. Couldn't find a
			// reduction of the Coppersmith algorithm at O(n^2.376) time,
			// and couldn't readily understand Strassen's algorithm at
			// O(n^(log2(7))) time.
			//
			// Probably wouldn't have understood Coppersmith's anyway.
			//
			// throw Exception("Programmer needs more math classes.");
			
			return c;
		} else {
			int[][] c = {{0}};
			return c;
		}
	}
}

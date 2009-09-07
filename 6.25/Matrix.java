class Matrix {
	public static void main(String[] args) {
		int[][] a =
			{{1, 2, 3},
			 {3, 4, 5},
			 {5, 6, 7}};
		int [][] b = 
			{{1, 0, 1},
			 {0, 1, 0},
			 {1, 0, 1}};
		
		int [][] c = Matrix.multiplyMatrix(a, b);
		
		System.out.println(Matrix.print(a)+"\n");
		System.out.println(Matrix.print(b)+"\n");
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
	
	/**
	 * Implode an array into a string with a separator between elements
	 * 
	 * Port of similar function in PHP and Python.
	 * Source: http://dracoblue.net/dev/implode-an-array-in-java/95/
	 *
	 * @param int[] inputArray the array to implode
	 * @param String separator the string to place between elements
	 *
	 * @return String imploded array
	 */
	public static String implode(int[] inputArray, String separator) {
		if (inputArray.length==0) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(inputArray[0]);
			for (int i=1;i<inputArray.length;i++) {
				sb.append(separator);
				sb.append(inputArray[i]);
			}
		return sb.toString();
		}
	}
	
	/**
	 * Implode an array into a string with a separator between elements
	 * 
	 * Port of similar function in PHP and Python.
	 * Source: http://dracoblue.net/dev/implode-an-array-in-java/95/
	 *
	 * @param String[] inputArray the array to implode
	 * @param String separator the string to place between elements
	 *
	 * @return String imploded array
	 */
	public static String implode(String[] inputArray, String separator) {
		if (inputArray.length==0) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(inputArray[0]);
			for (int i=1;i<inputArray.length;i++) {
				sb.append(separator);
				sb.append(inputArray[i]);
			}
		return sb.toString();
		}
	}
	
	public static String print(int[][] a) {
		String[] output = new String[a.length];
		
		for (int i = 0; i < a.length; i++) {
			output[i] = "[" + Matrix.implode(a[i], ", ") + "]";
		}
		
		return Matrix.implode(output, "\n");
	}
	
	public static int[][] newMatrix(int rows, int cols) {
		int[][] matrix = new int [rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = 0;
			}
		}
		
		return matrix;
	}
	
	public static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int a_cols = Matrix.cols(a);
		int b_rows = Matrix.rows(b);
		
		// Confirm a's cols = b's rows
		if (a_cols == b_rows) {
			// Create result matrix
			int[][] c = Matrix.newMatrix(a_cols, b_rows);
			
			// Using the naive algorithm at O(n^3) time. Couldn't find a
			// reduction of the Coppersmith algorithm at O(n^2.376) time,
			// and couldn't readily understand Strassen's algorithm at
			// O(n^(log2(7))) time.
			//
			// Probably wouldn't have understood Coppersmith's anyway.
			
			for (int i = 0; i < a_cols; i++) {
				for (int j = 0; j < b_rows; j++) {
					for (int k = 0; k < a_cols; k++) {
						c[i][j] += (a[i][k] * b[k][j]);
					}
				}
			}
			
			return c;
		} else {
			int[][] c = {{0}};
			return c;
		}
	}
}

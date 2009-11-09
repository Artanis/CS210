/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        System.out.println("Matrix A:");
        int[][] a = Matrix.get_matrix();
        
        System.out.println("Matrix B:\nNOTE: the rows in this matrix must be "+
            "the same as the columns in Matrix A");
        int[][] b = Matrix.get_matrix();
        
        // Multiply matrix
        int [][] c = Matrix.multiplyMatrix(a, b);
        
        // Print matrices
        System.out.println("Matrix A");
        System.out.println(Matrix.to_string(a)+"\n");
        
        System.out.println("Matrix B");
        System.out.println(Matrix.to_string(b)+"\n");
        
        System.out.println("Result Matrix:");
        System.out.println(Matrix.to_string(c));
    }
    
    /**
     * Asks the user to define and enter a matrix.
     * 
     * Based on the readAPuzzle function in the Sudoku solver example
     * 
     * @return int[][] matrix
     */
    public static int[][] get_matrix() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter matrix dimensions (Cols Rows): ");
        int cols = input.nextInt();
        int rows = input.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix values\nSpace separated, "+
            "in order of top-left to bottom-right:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        
        return matrix;
    }
    
    /**
     * Returns the number of rows in a matrix
     * 
     * Really just the length of the array
     * 
     * Here for completeness, paired with the cols function
     * 
     * @param int[][] matrix
     * 
     * @return Returns number of rows in matrix
     */
    public static int rows(int[][] a) {
        return a.length;
    }
    
    /**
     * Returns the number of columns in the matrix.
     *
     * Counts length of each row in matrix. If the matrix is ragged,
     * returns -1. If the matrix is rectangular returns the number of
     * columns.
     * 
     * @param int[][] matrix
     * 
     * @return number of columns in matrix, or -1 if matrix is ragged
     */
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
            // According to the author, he uses a StringBuffer rather
            // than a String for better performance with large arrays.
            // No real problem in this use, but I'd rather type this
            // comment than change the code to use a String.
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
     * This is stupid. Do you know how much I'd kill for duck-typing
     * right now? Hell, the two versions are character-for-character
     * identical aside from the function signature! Isn't an OO language
     * supposed to *limit* the unnecessary replication of code?
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
            // According to the author, he uses a StringBuffer rather
            // than a String for better performance with large arrays.
            // No real problem in this use, but I'd rather type this
            // comment than change code to use a String.
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
     * Converts a matrix to a string representation.
     *
     * @param int[][] a
     * 
     * @return String
     */
    public static String to_string(int[][] a) {
        String[] output = new String[a.length];
        
        for (int i = 0; i < a.length; i++) {
            output[i] = "[" + Matrix.implode(a[i], ", ") + "]";
        }
        
        return Matrix.implode(output, "\n");
    }
    
    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int a_cols = Matrix.cols(a);
        int a_rows = Matrix.rows(a);
        int b_cols = Matrix.cols(b);
        int b_rows = Matrix.rows(b);
        
        // Confirm a's cols = b's rows
        if (a_cols == b_rows) {
            // Create result matrix
            int[][] c = new int[a_rows][b_cols];
            
            // Using the naive algorithm at O(n^3) time. Couldn't find a
            // reduction of the Coppersmith algorithm at O(n^2.376) time,
            // and couldn't readily understand Strassen's algorithm at
            // O(n^(log2(7))) time.
            //
            // Probably wouldn't have understood Coppersmith's anyway.
            
            for (int i = 0; i < a_rows; i++) {
                for (int j = 0; j < b_cols; j++) {
                    for (int k = 0; k < a_cols; k++) {
                        c[i][j] += (a[i][k] * b[k][j]);
                    }
                }
            }
            
            return c;
        } else {
            System.out.println(
                "\n****************************\n" +
                  "Error: Incompatible Matrices" +
                "\n****************************\n");
            int[][] c = {{0}};
            return c;
        }
    }
}

/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ISBN_JOpt {
    public static void main (String[] args) {
        boolean console = false;
        
        long partial = ISBN.get_isbn(console);
        String isbn = String.format("%09d-%s", partial, ISBN.checksum(partial));
        ISBN.display_isbn(isbn, console);
    }
    
    public static long get_isbn(boolean console) {
        String message = "Enter the first 9 digits of the ISBN";
        String error   = "Error: Input is not a number";
        
        long input = 0;
        
        try {
            if (console) {
                Scanner in = new Scanner(System.in);
                System.out.print(message + ": ");
                input = in.nextLong();
            } else {
                input = Long.parseLong(JOptionPane.showInputDialog(null,
                    message, "ISBN",
                    JOptionPane.QUESTION_MESSAGE));
            }
        } catch (java.lang.NumberFormatException e) {
            // JOptionPane bad input
            JOptionPane.showMessageDialog(null, error);
            System.exit(0);
        } catch (java.util.InputMismatchException e) {
            // Scanner bad input
            System.out.println(error);
            System.exit(0);
        }
        
        return input;
    }
    
    public static void display_isbn(String isbn, boolean console) {
        String output = String.format("The full ISBN is %s", isbn);
        if (console) {
            System.out.println(output);
        } else {
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
    /**
     * Calculates the checksum of the given ISBN
     * Or any other number using the same algorithm...
     * 
     * @param long isbn number to check
     * 
     * @return String checksum
     */
    public static String checksum(long isbn) {
        int sum = 0;
        int length = (int)(Math.log10(isbn))+1;
        
        for(int i=1; i<length+1; i++) {
            int multiplier = -i+length+1;
            int digit = (int)(isbn/Math.pow(10,i-1)) % 10;
            int new_sum = sum + (digit*multiplier);
            //System.out.printf("%d: %d = %d + (%d * %d)\n", i, new_sum, sum, digit, multiplier);
            sum = new_sum;
        }
        sum = sum % 11;
        return (sum < 10)? Long.toString(sum): "X";
    }
}

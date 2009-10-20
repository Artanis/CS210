/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 * 
 * @author Erik Youngren <artanis.00@gmail.com>
 * 
 * Examination 02
 * ==============
 * 
 * 2009.10.19 18:00 - 2009.10.19 21:00
 * 
 * 5.11 - Financial application: computing commissions
 * ---------------------------------------------------
 * 
 * Write a method that computes the commission, using the scheme in 4.8.2,
 * "Problem: Finding the Sales Amount."
 * 
 * The header of the method is as follows:
 * 
 *     public static double computeCommission(double salesAmount)
 * 
 * Write a test program that displays the following table:
 * 
 *     Sales Amount    Commission
 *            10000        900.00
 *            15000       1500.00
 *              ...           ...
 *            95000      11100.00
 *           100000      11700.00
 * 
 */

public class Commission {
    public static void main(String[] args) {
        final int LOOP_INITIAL =  10000;
        final int LOOP_MAX     = 100000;
        final int LOOP_STEP    =   5000;
        
        System.out.printf("%14s%14s\n", "Sales Amount", "Commission");
        
        for(int i = LOOP_INITIAL; i <= LOOP_MAX; i += LOOP_STEP) {
            System.out.printf("%14.2f%14.2f\n", (double)i, Commission.computeCommission(i));
        }
    }
    
    /**
     * Compute the commission for a given amount of sales according to
     * the commission scheme, which is as follows:
     * 
     *              Sales Amount    Commission Rate
     *         0.01 to   5000.00    0.08
     *      5000.01 to  10000.00    0.10
     *     10000.01 to +infinity    0.12
     * 
     * @param double salesAmount The amount of sales
     * 
     * @return double comission
     * 
     */
    public static double computeCommission(double salesAmount) {
        final double RATE_LOW     = 0.08;
        final double RATE_MEDIUM  = 0.10;
        final double RATE_HIGH    = 0.12;
        
        final double SALES_LOW_MAX    =  5000.00;
        final double SALES_MEDIUM_MAX = 10000.00;
        final double SALES_HIGH_MAX   = Float.MAX_VALUE;
        
        double commission = 0.00;
        
        if (salesAmount >= SALES_MEDIUM_MAX) {
            commission =
                (SALES_LOW_MAX * RATE_LOW) +
                ((SALES_MEDIUM_MAX - SALES_LOW_MAX) * RATE_MEDIUM) +
                ((salesAmount - SALES_MEDIUM_MAX) * RATE_HIGH);
        } else if (salesAmount >= SALES_LOW_MAX) {
            commission =
                (SALES_LOW_MAX * RATE_LOW) +
                ((salesAmount - SALES_LOW_MAX) * RATE_MEDIUM);
        } else {
            commission = (salesAmount * RATE_LOW);
        }
        
        return commission;
    }
}

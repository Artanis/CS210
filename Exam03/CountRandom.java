/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

public class CountRandom {
    public static void main(String[] args) {
        final int ROLLS = 100;
        final int LOWER_BOUND = 0;
        final int UPPER_BOUND = 9;
        
        int[] counts = CountRandom.roll(LOWER_BOUND, UPPER_BOUND, ROLLS);
        
        int max = CountRandom.max(counts);
        
        for (int i = 0; i < counts.length; i++) {
            System.out.print(CountRandom.toString(i, counts[i], max));
        }
    }
    
    /**
     * Makes the specified number of rolls, within the given range,
     * and returns the number of hits each integer received.
     * 
     * @param int lower The lower bound for the roll
     * @param int upper The upper bound for the roll
     * @param int rolls The number of rolls to make
     * 
     * @return int[] Series of hits for each number in the range.
     * 
     */
    static int[] roll (int lower, int upper, int rolls) {
        int[] counts = new int[upper - lower + 1];
        
        for (int i = 0; i < rolls; i++) {
            counts[Random.range(lower, upper) - lower] += 1;
        }
        
        return counts;
    }
    
    /**
     * Find the maximum value in the series.
     * 
     * @return int maximum value
     * 
     */
    static int max (int[] array) {
        int max = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    /**
     * Creates a string displaying the number of hits each number got.
     * 
     * If the optional parameter high is provided, also creates a
     * graphical representation.
     * 
     * @param int entry The number
     * @param int quantity The number of hits it got
     * @param int high Optional. The largest number of hits in the
     *                 series.
     * 
     * @return String
     * 
     */
    static String print (int entry, int quantity) {
        return String.format("%3d %3d\n",
            entry, quantity);
    }
    
    /**
     * Creates a string displaying the number of hits each number got.
     * 
     * If the optional parameter high is provided, also creates a
     * graphical representation.
     * 
     * @param int entry The number
     * @param int quantity The number of hits it got
     * @param int high Optional. The largest number of hits in the
     *                 series.
     * 
     * @return String
     * 
     */
    static String toString (int entry, int quantity, int high) {
        final int SCREEN_WIDTH = 79 - 11;
        
        String graph = "";
        
        int size = (int)((double)quantity / high * SCREEN_WIDTH);
        for (int i = 0; i < size-1; i++) {
            graph += "-";
        }
        
        graph += "+";
        
        String output = String.format("#%03d [%-68s] %-3d\n",
            entry, graph, quantity);
        return output;
    }
}

class Random {
    /**
     * Generate a rnadom number within the given range
     * 
     * @param int lower Optional. Default 0
     * @param int upper
     * 
     * @return int
     * 
     */
    static int range (int upper) {
        return Random.range(0, upper);
    }
    
    /**
     * Generate a rnadom number within the given range
     * 
     * @param int lower Optional. Default 0
     * @param int upper
     * 
     * @return int
     * 
     */
    static int range (int lower, int upper) {
        return (int)((Math.random() * (upper - lower + 1)) + lower);
    }
}

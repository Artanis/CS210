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
            System.out.print(CountRandom.print(i, counts[i], max));
        }
    }
    
    static int[] roll (int lower, int upper, int rolls) {
        int[] counts = new int[upper - lower + 1];
        
        for (int i = 0; i < rolls; i++) {
            counts[Random.range(lower, upper) - lower] += 1;
        }
        
        return counts;
    }
    
    static int max (int[] array) {
        int max = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    static String print (int entry, int quantity) {
        return String.format("%3d %3d\n",
            entry, quantity);
    }
    
    static String print (int entry, int quantity, int high) {
        String graph = "";
        int size = (int)((double)quantity / high * 68);
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
    static int range (int upper) {
        return Random.range(0, upper);
    }
    
    static int range (int lower, int upper) {
        return (int)((Math.random() * (upper - lower + 1)) + lower);
    }
}

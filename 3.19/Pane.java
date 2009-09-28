/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pane {
    public static void main (String[] args) {
        boolean console = false;
        
        long partial = ISBN.get_isbn(console);
        String isbn = String.format("%09d-%s", partial,
            ISBN.checksum(partial));
        
        ISBN.display_isbn(isbn, console);
    }
}

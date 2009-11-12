/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

/**
 * A test driver for the Rectangle class
 * 
 */
public class RectDriver {
    public static void main(String[] args) {
        Rectangle a,b;
        
        a = new Rectangle(4, 40);
        a.set_color("red");
        
        b = new Rectangle(3.5, 35.9, "red");
        
        System.out.printf(
            "\n" +
            "A %s\n"+
            "    Construction: %s\n" +
            "    Area: %1.2f\n" +
            "    Perimeter: %1.2f\n",
            a.str(), a.repr(), a.getArea(), a.getPerimeter());
        
        System.out.printf(
            "\n" +
            "A %s\n"+
            "    Construction: %s\n" +
            "    Area: %1.2f\n" +
            "    Perimeter: %1.2f\n",
            b.str(), b.repr(), b.getArea(), b.getPerimeter());
    }
}

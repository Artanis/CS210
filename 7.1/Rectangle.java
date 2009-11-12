/**
 * Computer Science 210 - Introduction to Computer Programming - Java
 * Chang-Shyh Peng <peng@clunet.org> <http://public.clunet.org/~peng>
 *
 * @author Erik Youngren <artanis.00@gmail.com>
 *
 */

/**
 * A class defining a rectangle.
 * 
 * Provides methods for calculating area and perimeter. Also supports
 * colors.
 * 
 */
class Rectangle {
    /**
     * The width of the rectangle
     * 
     */
    private double width = 1;
    
    /**
     * The height of the rectangle
     * 
     */
    private double height = 1;
    
    /**
     * The color of the rectangle
     * 
     */
    private String color = "white";
    
    /**
     * Default constructor.
     * 
     * Creates a white, 1x1 rectangle.
     * 
     */
    Rectangle() {
        // pass
    }
    
    /**
     * Size provided constructor.
     * 
     * Creates a white rectangle of the given size.
     * 
     */
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Size and color provided constructor.
     * 
     * Creates a rectangle of the given color and of the given size.
     * 
     */
    Rectangle(double width, double height, String color) {
        this(width, height);
        this.color = color;
    }
    
    /**
     * Gets the rectangle width.
     * 
     * @return double width
     * 
     */
    public double get_width() {
        return this.width;
    }
    
    /**
     * Sets the rectangle width.
     * 
     * @return boolean success
     * 
     */
    public boolean set_width(double width) {
        this.width = width;
        return true;
    }
    
    /**
     * Gets the rectangle height.
     * 
     * @return double height
     * 
     */
    public double get_height() {
        return this.height;
    }
    
    /**
     * Sets the rectangle height.
     * 
     * @return boolean success
     * 
     */
    public boolean set_height(double height) {
        this.height = height;
        return true;
    }
    
    /**
     * Gets the rectangle color.
     * 
     * @return String color
     * 
     */
    public String get_color() {
        return this.color;
    }
    
    /**
     * Sets the rectangle color.
     * 
     * Stored in lower case.
     * 
     * @return boolean success
     * 
     */
    public boolean set_color(String color) {
        this.color = color.toLowerCase();
        return true;
    }
    
    /**
     * Calculates the area of the rectangle.
     * 
     * @return double area
     * 
     */
    public double getArea() {
        return this.height * this.width;
    }
    
    /**
     * Calculates the perimeter of the rectangle.
     * 
     * @return double perimeter
     * 
     */
    public double getPerimeter() {
        return 2 * this.height + 2 * this.width;
    }
    
    /**
     * Creates a human readable string describing the object.
     * 
     * @return String description
     * 
     */
    public String str() {
        return String.format("%s %1.2fx%1.2f rectangle",
            this.color, this.width, this.height);
    }
    
    /**
     * Creates an exec-able representation that will reconstruct the
     * object.
     * 
     * @return String representation
     * 
     */
    public String repr() {
        String output = "Rectangle(";
        
        if (this.width  != 1 || this.height != 1) {
            output += String.format("%f, %f",
                this.width, this.height);
        }
        
        if (this.color != "white") {
            output += String.format(", \"%s\"", this.color);
        }
        
        output += ");";
        
        return output;
    }
}

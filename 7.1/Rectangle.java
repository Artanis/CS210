class Rectangle {
    private double width = 1;
    private double height = 1;
    
    private String color = "white";
    
    Rectangle() {
        // pass
    }
    
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    Rectangle(double width, double height, String color) {
        this(width, height);
        this.color = color;
    }
    
    public double get_width() {
        return this.width;
    }
    
    public boolean set_width(double width) {
        this.width = width;
        return true;
    }
    
    public double get_height() {
        return this.height;
    }
    
    public boolean set_height(double height) {
        this.height = height;
        return true;
    }
    
    public String get_color() {
        return this.color;
    }
    
    public boolean set_color(String color) {
        this.color = color.toLowerCase();
        return true;
    }
    
    public double getArea() {
        return this.height * this.width;
    }
    
    public double getPerimeter() {
        return 2 * this.height + 2 * this.width;
    }
    
    public String str() {
        return String.format("%s %1.2fx%1.2f rectangle",
            this.color, this.width, this.height);
    }
    
    public String repr() {
        String output = "Rectangle(";
        
        if (this.width  != 1) {
            output += String.format("%1.2f", this.width);
        }
        
        if (this.height != 1) {
            output += String.format(", %1.2f", this.height);
        }
        
        if (this.color != "white") {
            output += String.format(", \"%s\"", this.color);
        }
        
        output += ");";
        
        return output;
    }
}

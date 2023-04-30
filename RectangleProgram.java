class Rectangle
{
     //Private members
    private double width;
    private double length;
    
    //No args constructor
    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    //Constructor wwith args
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    //Setter methods
    public void setWidth(double n) {
        this.width = n;
    }

    public void setLength( double n) {
        this.length = n;
    }

    //Getter methods
    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    //Return the area of the rectangle
    public double getArea() {
        return (this.length * this.width);
    }

    //Return the sum of all the sides of the rectangle
    public double getPerimeter() {
        return (this.length * 2) + (this.width * 2);
    }
    
}

public class RectangleProgram
{
    public static void main(String[] args) {

        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle(4.0, 4.0);

        System.out.println(rect.getArea());
        System.out.println(rect2.getPerimeter());
    }
}
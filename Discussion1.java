class Circle {
    /** The radius of this circle */
    double radius = 1.0;
    
    /** Construct a circle object */
    Circle() {
    }
    
    /** Construct a circle object */
    Circle(double newRadius) {
      radius = newRadius;
    }
    
    /** Return the area of this circle */
    double getArea() {
      return radius * radius * 3.14159;
    }
}
    
public class Discussion1 {
    public static void main(String[] args) {

        //Create two Circle objects
        Circle circle = new Circle();
        Circle circle2 = new Circle(5.5);

        //Print out circles' areas
        System.out.println(circle.getArea());
        System.out.println(circle2.getArea());
    } 
}

package Basics2.Assignment3;


public class Assignment3 {
    public static void main(String[] args) {
        //test all shapes
        Shape rectangle = new Rectangle(2, 5);
        Shape circle = new Circle(6.74);
        Shape triangle = new Triangle(2, 4, 3);

        rectangle.display();
        circle.display();
        triangle.display();
    }
}

/* copy of console
 * ▬ base: 2.00, height: 5.00, area: 10.00
 * ●, radius: 6.74, area: 142.72
 * ▲, Side A: 2.00, Side B: 4.00, Side C: 3.00, Area: 2.90
 */


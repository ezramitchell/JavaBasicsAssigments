package Basics2.Assignment3;

public class Circle implements Shape{
    private final double r;

    public Circle(double radius){
        r = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (r * r);
    }

    @Override
    public void display() {
        System.out.printf("●, radius: %.2f, area: %.2f %n", r, calculateArea());
    }
}

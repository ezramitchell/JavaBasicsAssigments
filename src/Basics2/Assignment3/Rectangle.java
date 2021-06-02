package Basics2.Assignment3;

import java.security.InvalidParameterException;

public class Rectangle  implements Shape{
    private final double x;
    private final double y;

    public Rectangle(double base, double height){
        if(base <= 0 || height <= 0) throw new InvalidParameterException("Invalid Rectangle");
        x = base;
        y = height;
    }


    @Override
    public double calculateArea() {
        return x * y;
    }

    @Override
    public void display() {
        System.out.printf("▬ base: %.2f, height: %.2f, area: %.2f %n", x, y, calculateArea());
    }
}

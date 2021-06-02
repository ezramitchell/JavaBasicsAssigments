package Basics2.Assignment3;

import java.security.InvalidParameterException;

public class Triangle implements Shape{
    private final double a;
    private final double b;
    private final double c;

    /**
     *
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public Triangle(double a, double b, double c){
        if( !(a + b > c | a + c > b | b + c > a) )throw new InvalidParameterException("Invalid Triangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        //herons formula
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void display() {
        System.out.printf("▲, Side A: %.2f, Side B: %.2f, Side C: %.2f, Area: %.2f %n", a, b, c, calculateArea());
    }
}

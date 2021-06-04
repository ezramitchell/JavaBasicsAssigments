package Basics4.Test;

import Basics4.Line;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void slopeTest(){
        //test normal slope
        Line l1 = new Line(4, 5, 8, 15);
        assertEquals(2.5, l1.getSlope(), 0.0001);
        //test divide by zero
        try{
            Line l2 = new Line(0, 0, 0, 0);
            l2.getSlope();
            fail("Divided by 0");
        } catch (ArithmeticException ignored){}
    }
    @Test
    public void distanceTest(){
        Line l1 = new Line(4, 5, 8, 15);
        assertEquals(10.7703, l1.getDistance(), 0.0001);
    }

    @Test
    public void parallelTest(){
        //test horizontal
        Line l1 = new Line(0, 0, 1, 0);
        Line l2 = new Line(1, 1, 2, 1);
        assertTrue(l1.parallelTo(l2));
        //test 1
        l1 = new Line(0, 0, 1, 1);
        l2 = new Line(-1, -2, 0, -1);
        assertTrue(l1.parallelTo(l2));
        //test false
        l2 = new Line(0, 0, 1, -1);
        assertFalse(l1.parallelTo(l2));

    }
}

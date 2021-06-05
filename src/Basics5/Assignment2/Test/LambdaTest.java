package Basics5.Assignment2.Test;

import Basics5.Assignment2.Lambdas;
import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void testOdd(){
        Lambdas.PerformOperation odd = Lambdas.isOdd();

        assertTrue(odd.operation(7));
        assertTrue(odd.operation(3));
        assertFalse(odd.operation(2));
    }

    @Test
    public void testPrime(){
        Lambdas.PerformOperation prime = Lambdas.isPrime();

        assertTrue(prime.operation(13));
        assertTrue(prime.operation(79));
        assertTrue(prime.operation(151));
        assertTrue(prime.operation(199));
        assertFalse(prime.operation(10));
    }

    @Test
    public void testPalindrome(){
        Lambdas.PerformOperation pal = Lambdas.isPalindrome();

        assertTrue(pal.operation(12321));
        assertTrue(pal.operation(141));
        assertTrue(pal.operation(15551));
        assertFalse(pal.operation(15678));
    }
}

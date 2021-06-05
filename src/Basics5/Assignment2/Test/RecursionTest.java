package Basics5.Assignment2.Test;

import Basics5.Assignment2.Recursion;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void groupSumTest(){
        int[] arr = {2, 4, 8};
        assertTrue(Recursion.groupSum(arr, 10));
        arr = new int[]{1, 2, 4, 8, 1};
        assertTrue(Recursion.groupSum(arr, 14));
        arr = new int[]{2, 4, 4, 8};
        assertFalse(Recursion.groupSum(arr, 14));
        arr = new int[]{2, 4, 4, 8, 8};
        assertTrue(Recursion.groupSum(arr, 18));
    }
}

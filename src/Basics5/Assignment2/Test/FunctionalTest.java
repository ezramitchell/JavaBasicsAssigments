package Basics5.Assignment2.Test;

import org.junit.Test;

import static org.junit.Assert.*;

import Basics5.Assignment2.Map;
import Basics5.Assignment2.Functional;

public class FunctionalTest {

    @Test
    public void RightTest() {
        Map<Integer> right = Functional.rightDigit();

        Integer[] in = {1, 22, 93};
        Integer[] out = {1, 2, 3};
        assertArrayEquals(out, right.map(in));

        in = new Integer[]{16, 8, 886, 8, 1};
        out = new Integer[]{6, 8, 6, 8, 1};
        assertArrayEquals(out, right.map(in));

        in = new Integer[]{10, 0};
        out = new Integer[]{0, 0};
        assertArrayEquals(out, right.map(in));
    }

    @Test
    public void doubleValTest() {
        Map<Integer> doubleVal = Functional.doubleValue();

        Integer[] in = {1, 2, 3};
        Integer[] out = {2, 4, 6};
        assertArrayEquals(out, doubleVal.map(in));

        in = new Integer[]{6, 8, 6, 8, -1};
        out = new Integer[]{12, 16, 12, 16, -2};
        assertArrayEquals(out, doubleVal.map(in));

        in = new Integer[]{};
        out = new Integer[]{};
        assertArrayEquals(out, doubleVal.map(in));

    }

    @Test
    public void removeXTest() {
        Map<String> removeX = Functional.removeX();

        String[] in = {"ax", "bb", "cx"};
        String[] out = {"a", "bb", "c"};
        assertArrayEquals(out, removeX.map(in));

        in = new String[]{"xxax", "xbxbx", "xxcx"};
        out = new String[]{"a", "bb", "c"};
        assertArrayEquals(out, removeX.map(in));

        in = new String[]{"x"};
        out = new String[]{""};
        assertArrayEquals(out, removeX.map(in));

    }
}

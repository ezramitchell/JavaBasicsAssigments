package Basics5.Assignment2;

import java.util.Arrays;



public class Functional {


    public static Map<Integer> rightDigit() {
        return list -> Arrays.stream(list).map(x -> x % 10).toArray(Integer[]::new);
    }

    public static Map<Integer> doubleValue() {
        return list -> Arrays.stream(list).map(x -> x * 2).toArray(Integer[]::new);
    }

    public static Map<String> removeX() {
        return list -> Arrays.stream(list).map(str -> str.replace("x", "")).toArray(String[]::new);
    }
}

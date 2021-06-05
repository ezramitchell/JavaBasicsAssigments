package Basics5.Assignment1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        int[] ints = {1, 4, 5, 6, 2, 42, 5, 2, 5};
        joinInts(ints);
        String[] strings = {"these", "are", "my", "test", "strings", "app"};
        filterA(strings);
    }

    public static void joinInts(int[] ints){
        String joined = IntStream.of(ints).mapToObj(Streams::appendEven).collect(Collectors.joining(", "));
        System.out.println(joined);
    }

    public static String appendEven(int x){
        if(x % 2 == 0) return "e" + x;
        else return "o" + x;
    }

    public static void filterA(String[] strings){
        System.out.println(Arrays.stream(strings).filter(s -> s.charAt(0) == 'a' && s.length() == 3).collect(Collectors.joining(", ")));
    }
}

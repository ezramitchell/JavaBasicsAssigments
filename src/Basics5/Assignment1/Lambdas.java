package Basics5.Assignment1;

import java.util.Arrays;
import java.util.Comparator;

public class Lambdas {
    public static void main(String[] args) {
        String[] strings = {"This", "is", "my", "list", "of", "strings", "ex"};
        sortStrings(strings);
    }

    public static void sortStrings(String[] strings){
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, Comparator.comparingInt(s -> Character.toLowerCase(s.charAt(0))));
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, (s1, s2) -> {
            char c1 = Character.toLowerCase(s1.charAt(0));
            char c2 = Character.toLowerCase(s2.charAt(0));
            if(c1 == 'e') return -1;
            if(c2 == 'e') return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, Lambdas::compareE);
        System.out.println(Arrays.toString(strings));
    }

    public static int compareE(String s1, String s2){
        char c1 = Character.toLowerCase(s1.charAt(0));
        char c2 = Character.toLowerCase(s2.charAt(0));
        if(c1 == 'e') return -1;
        if(c2 == 'e') return 1;
        else return 0;
    }

}

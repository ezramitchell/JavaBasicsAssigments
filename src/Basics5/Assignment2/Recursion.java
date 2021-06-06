package Basics5.Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Recursion {

    /**
     * Starts recursive method
     *
     * @param arr     array to sum
     * @param desired desired sum
     * @return True if sum is possible
     */
    public static boolean groupSum(int[] arr, int desired) {
        //group values together
        ArrayList<Integer> grouped = new ArrayList<>();

        int sum = 0;
        boolean duplicateFound = false;

        grouped.add(0); //this is for the recursive function, the first element needs to be padding

        for (int i = 0; i + 1 < arr.length; i++) { //iterate until second to last value
            if (arr[i] == arr[i + 1]) { //two number are consecutive duplicates
                sum += arr[i];
                duplicateFound = true;
                if (i + 2 == arr.length) grouped.add(sum + arr[i + 1]); //add last value
            } else {
                if (duplicateFound) { //end of duplicate add sum to grouped list
                    grouped.add(sum + arr[i]); //include current value
                    sum = 0;
                    duplicateFound = false;
                } else grouped.add(arr[i]); //no duplicate just add value
                if (i + 2 == arr.length) grouped.add(arr[i + 1]); //add last value
            }
        }

        System.out.println(Arrays.toString(grouped.toArray()));
        //change arraylist to intStream with extra value added to front
        return groupSum(IntStream.of(grouped.stream().mapToInt(Integer::intValue).toArray()), 0, desired) == desired;
    }

    /**
     * Recursive method implementing groupSum, first element of IntStream should be padding
     *
     * @param ints    stream of integers, needs padding number
     * @param sum     current Sum
     * @param desired desired number
     * @return ending sum
     */
    private static int groupSum(IntStream ints, int sum, int desired) {
        if (sum >= desired) return sum;

        //add largest number that doesn't bring sum past desired or return current sum
        //stream contains previous iterations max hence the skip
        int[] result = ints.skip(1).filter(x -> x + sum <= desired).map(i -> ~i).sorted().map(i -> ~i).toArray(); //padding is for this skip on first call
        if (result.length > 0) {
            return groupSum(IntStream.of(result), sum + result[0], desired);
        }

        return sum;
    }

}

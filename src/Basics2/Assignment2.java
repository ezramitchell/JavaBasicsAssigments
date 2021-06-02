package Basics2;

import java.util.Arrays;
import java.util.Random;

public class Assignment2 {
    public static void main(String[] args) {
        int[] arr = constructArray(15, 100);

        //find max
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
                maxIndex = i;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.printf("Max: %s, Position: %s", maxVal, maxIndex + 1); // + 1 for easier understanding in output
    }

    private static int[] constructArray(int length, int bound){
        Random rand = new Random();
        int[] arr = new int[length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(bound);
        }
        return arr;
    }
}

/* Copy of console
 * [47, 31, 60, 4, 28, 34, 91, 96, 19, 67, 99, 95, 15, 53, 27]
 * Max: 99, Position: 11
 */
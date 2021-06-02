package Basics2;

import java.util.Arrays;
import java.util.Random;

public class Assignment2 {
    public static void main(String[] args) {
        int[][] arr = constructArray(3, 100);

        //find max
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxVal) {
                    maxVal = arr[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.printf("Max: %s, Position: (%s, %s)", maxVal, maxRow + 1, maxCol + 1); // + 1 for easier understanding in output
    }

    private static int[][] constructArray(int length, int bound){
        Random rand = new Random();
        int[][] arr = new int[length][length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = rand.nextInt(bound);
            }
        }
        return arr;
    }
}

/* Copy of console
 * [[72, 65, 53], [49, 79, 83], [90, 67, 94]]
 * Max: 94, Position: (3, 3)
 */
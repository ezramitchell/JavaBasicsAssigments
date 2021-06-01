package Basics1;

import java.util.Random;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        //choose number
        int number = new Random().nextInt(100) + 1;
        int guess = -500;
        int depth = 0;

        Scanner input = new Scanner(System.in);
        while(depth < 5 && guess < number - 10 | guess > number + 10){
            System.out.println("Guess a number between 1-100");
            guess = constrainInt(input.nextInt(), 100, 1);
            depth++;
        }

        if(depth < 5)
            System.out.printf("Correct you guessed %s and had to guess between %s-%s %n", guess, constrainInt(number - 10, 100, 1), constrainInt(number + 10, 100, 1));
        else
            System.out.printf("Sorry, answer is %s %n", number);
    }

    public static int constrainInt(int num, int high, int low){
        return Math.max(low, Math.min(high, num));
    }
}

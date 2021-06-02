package Basics2;

import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String command = "";
        double sum = 0;
        StringBuilder invalidEntries = new StringBuilder("Invalid Entries: ");

        while(!command.equalsIgnoreCase("quit")){
            System.out.println("Enter a number to add or quit to exit and print result");
            command = scnr.nextLine();

            try{
                sum += Double.parseDouble(command);
            } catch (NumberFormatException e){
                if(!command.equalsIgnoreCase("quit")){
                    invalidEntries.append(command);
                    invalidEntries.append(", ");
                }
            }
        }

        System.out.println("Entries sum to " + sum);
        System.out.println(invalidEntries);
    }
}

/* Copy of console
 * Enter a number to add or quit to exit and print result
 * 1
 * Enter a number to add or quit to exit and print result
 * 2
 * Enter a number to add or quit to exit and print result
 * f
 * Enter a number to add or quit to exit and print result
 * g
 * Enter a number to add or quit to exit and print result
 * quit
 * Entries sum to 3.0
 * Invalid Entries: f, g,
 *
 * Process finished with exit code 0
 */

package Basics3;

import java.io.*;

public class Assignment3 {
    //count characters
    public static void main(String[] args) {
        //arg 0 is file to read
        //arg 1 is character to look for
        if (args.length < 2) return;
        try (
                FileReader fr = new FileReader(args[0]);
                BufferedReader reader = new BufferedReader(fr)
        ) {
            long count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.chars().filter(ch -> ch == args[1].charAt(0)).count();
            }
            System.out.printf("Total occurrences of '%s' in %s is %s", args[1].charAt(0), args[0], count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Program arguments "res/append.txt a"
console output "Total occurrences of 'a' in res/append.txt is 2"

 */

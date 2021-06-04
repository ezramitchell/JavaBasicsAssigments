package Basics3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment2 {
    //append text
    public static void main(String[] args) {
        if (args.length <= 1) return;
        try (//both need to be closed i think
             FileWriter fw = new FileWriter(args[0], true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            for (int i = 1; i < args.length; i++) {
                writer.write(args[i]);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* Stuff for grading
 Program arguments "res\append.txt "Append this text""

 append.txt before running

    This needs to be here after appending

 append.txt after running

    This needs to be here after appending
    Append this text
 */

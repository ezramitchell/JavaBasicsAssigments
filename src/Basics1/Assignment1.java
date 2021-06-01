package Basics1;

/*
format
repetitions:character:repetitions:character  n=newline (can also be repeated)
ex.
4*n5*n6n.

cannot print numbers
implicit 1 if no number is specified,
n creates groups, pattern must end with n
 */


public class Assignment1 {
    public static void main(String[] args) {
        System.out.println("1)");
        printPattern("1*n2*n3*n4*n9.2n");
        System.out.println("2)");
        printPattern("9.n4*n3*n2*n1*2n");
        System.out.println("3)");
        printPattern("1*n3*n5*n7*n9.2n", true, 9);
        System.out.println("4)");
        printPattern("9.n7*n5*n3*n1*2n", true, 9);
    }

    /**
     * No argument version, just for readability
     * @param pattern
     */
    public static void printPattern(String pattern) {
        printPattern(pattern, false, 0);
    }

    /**
     * Prints pattern according to format shown in comment. Summary of format [repetition][character]...[repetition][character],
     * no repetition is inferred as 1, n=newline, must end with n
     * @param pattern
     * @param centered
     * @param lineLength
     */
    public static void printPattern(String pattern, boolean centered, int lineLength) {
        //iterate string, extract instructions
        //non numeric characters are instructions
        char[] instructions = pattern.toCharArray();

        StringBuilder numberBuffer = new StringBuilder();
        StringBuilder lineBuffer = new StringBuilder();

        for (char c : instructions) {
            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {
                int repetitions = parse(numberBuffer.toString());
                numberBuffer.setLength(0);//reset numberBuffer

                //print lineBuffer if new line
                if (Character.toLowerCase(c) == 'n') {
                    if (centered) {
                        //add padding
                        System.out.print(" ".repeat((lineLength - lineBuffer.length()) / 2));
                        //potential error with invalid line lengths
                    }

                    System.out.print(lineBuffer); //print buffer
                    System.out.print("\n".repeat(repetitions)); //print newlines
                    lineBuffer.setLength(0); //reset buffer

                } else { //else add to lineBuffer
                    lineBuffer.append(Character.toString(c).repeat(repetitions));
                }
            }
        }
    }

    /**
     * Safely parse string, infers 1 on errors
     * @param s string of digits
     * @return parsed int
     */
    private static int parse(String s) {
        if (s.length() == 0) return 1; //inferred 1
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
    }
}


/*
1)
*
**
***
****
.........

2)
.........
****
***
**
*

3)
    *
   ***
  *****
 *******
.........

4)
.........
 *******
  *****
   ***
    *


Process finished with exit code 0
 */
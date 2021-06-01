package Basics1;

/*
format
repetitions:character  n=newline
ex.
4*n5*n6n.

cannot print numbers
implicit 1 if no number is specified,
must end with n
 */


public class Assignment1 {
    public static void main(String[] args) {
        printPattern("1*n2*n3*n4*n9.2n");
        printPattern("9.n4*n3*n2*n1*2n");
        printPattern("1*n3*n5*n7*n9.2n", true, 9);
        printPattern("9.n7*n5*n3*n1*2n", true, 9);
    }

    public static void printPattern(String pattern){
        printPattern(pattern, false, 0);
    }

    public static void printPattern(String pattern, boolean centered, int lineLength){
        //iterate string, extract instructions
        //non numeric characters are instructions
        char[] instructions = pattern.toCharArray();

        StringBuilder numberBuffer = new StringBuilder();
        StringBuilder lineBuffer = new StringBuilder();

        for(char c : instructions){
            if(Character.isDigit(c)){
                numberBuffer.append(c);
            }else{
                int repetitions = parse(numberBuffer.toString());
                numberBuffer.setLength(0);//reset numberBuffer

                //print lineBuffer if new line
                if(Character.toLowerCase(c) == 'n'){
                    if(centered){
                        //add padding
                        System.out.print(" ".repeat((lineLength - lineBuffer.length()) / 2));
                        //potential error with invalid line lengths
                    }

                    System.out.print(lineBuffer); //print buffer
                    System.out.print("\n".repeat(repetitions)); //print newlines
                    lineBuffer.setLength(0); //reset buffer

                }else { //else add to lineBuffer
                    lineBuffer.append(Character.toString(c).repeat(repetitions));
                }
            }
        }
    }

    public static int parse(String s){
        if(s.length() == 0) return 1; //inferred 1
        try{
            return Integer.parseInt(s);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }
}

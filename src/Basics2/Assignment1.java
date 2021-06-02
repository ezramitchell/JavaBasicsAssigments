package Basics2;

public class Assignment1 {
    public static void main(String[] args) {
        double sum = 0;
        StringBuilder invalidEntries = new StringBuilder("Invalid Entries: ");
        for(String s : args) {
            try {
                sum += Double.parseDouble(s);
            } catch (NumberFormatException e) {
                invalidEntries.append(s);
                invalidEntries.append(", ");
            }
        }

        System.out.println("Entries sum to " + sum);
        System.out.println(invalidEntries);
    }
}

/* Copy of console, arguments are 2 5 6 j u
Entries sum to 13.0
Invalid Entries: j, u,
 */

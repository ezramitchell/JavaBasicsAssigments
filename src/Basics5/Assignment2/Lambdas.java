package Basics5.Assignment2;

public class Lambdas {
    @FunctionalInterface
    interface PerformOperation {
        boolean operation(int x); //could be formatted to string to match assignment sample output but that's not very intuitive
    }

    public static void main(String[] args) {
        PerformOperation odd = isOdd();
        PerformOperation prime = isPrime();
        PerformOperation palindrome = isPalindrome();

        System.out.println(odd.operation(5));
        System.out.println(prime.operation(7));
        System.out.println(palindrome.operation(757));
    }

    public static PerformOperation isOdd() {
        return x -> x % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return x -> {
            if (x <= 1) return false; //removes 1 and negatives
            if (x <= 3) return true; //takes care of 2 and 3

            if (x % 2 == 0 || x % 3 == 0) return false;

            //iterate numbers in 6k +- 1
            for (int i = 5; i * i <= x /*only check until sqrt*/; i += 6) {
                if (x % i == 0 || x % (i + 2) == 0) return false;
            }

            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return x -> {
            String original = String.valueOf(x);
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        };
    }
}

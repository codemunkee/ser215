import java.util.Scanner;

/**
 * Created by Russell Nealis on 6/4/16 for SER 215 at ASU (ASSIGNMENT 6).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */
public class GreatestCommonDivisor {
    /* This class calculates the greatest common divisor for a pair
       of supplied integers.
     */

    private static int[][] getUserInput() {
        /* Prompt the user for pairs of numbers to find the greatest common
           divisor for. Returns the pairs as an array of arrays.
        */

        // holds the number pairs provided by the user
        int[][] numberPairs;

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the number of GCD pairs to identify: ");
        while(!scan.hasNextInt()) {
            System.out.println("\nYou must provide an integer for the " +
                    "number of pairs to enter.\n");
            System.out.print("Please enter the number of GCD pairs to identify: ");
            scan.next();
        }

        // count of pairs to be provided
        int pairCount = scan.nextInt();

        // create our array object for holding the number pairs
        numberPairs = new int[pairCount][2];

        // get the number pairs from the user
        for (int queryCount = 0; queryCount < pairCount; queryCount++) {

            System.out.printf("\nEnter Data for Pair %s of %s\n\n", queryCount + 1, pairCount);

            // We query the user twice, one for each number of the pair,
            // there is code duplication here but it helps with readability

            do {
                System.out.print("Enter 1st number of pair: ");
                while (!scan.hasNextInt()) {
                    System.out.println("\nYou must provide a number.\n");
                    System.out.print("Enter 1st number of pair: ");
                    scan.next();
                }
                numberPairs[queryCount][0] = scan.nextInt();
                if (numberPairs[queryCount][0] == 0) {
                    System.out.println("\nYou will never find a divisor for 0.\n");
                }
            } while (numberPairs[queryCount][0] == 0);


            do {
                System.out.print("Enter 2nd number of pair: ");
                while (!scan.hasNextInt()) {
                    System.out.println("\nYou must provide a number.\n");
                    System.out.print("Enter 2nd number of pair: ");
                    scan.next();
                }
                numberPairs[queryCount][1] = scan.nextInt();
                if (numberPairs[queryCount][1] == 0) {
                    System.out.println("\nYou will never find a divisor for 0.\n");
                }
            } while (numberPairs[queryCount][1] == 0);

        }

        // Blank line to separate user input from next console output
        System.out.println();

        return numberPairs;
    }

    public static int getGCD(int A, int B) {
        /* Takes two integers and finds their greatest common divisor by
           using Euclid's division algorithm.
         */

        // we want A to be greater than B, if that's not the case,
        // make it so it is
        if (B > A) {
            int tmp = A;
            A = B;
            B = tmp;
        }

        while (true) {
            int C = A % B;
            // if there isn't a remainder when dividing the two, we've
            // found the GCD
            if (C == 0) {
                return B;
            } else {
                A = B;
                B = C;
            }
        }
    }

    public static void main(String args[]) {
        // Get number pairs from the user
        int[][] numberPairs = getUserInput();

        // Go through the pairs and print each as well as their GCD
        for (int[] pair : numberPairs) {
            System.out.printf("%s %s %s\n", pair[0], pair[1], getGCD(pair[0], pair[1]));
        }
    }
}

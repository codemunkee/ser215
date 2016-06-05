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

            System.out.printf("\nEnter Data for Pair %s of %s\n", queryCount + 1, pairCount);

            // We query the user twice, one for each number of the pair,
            // there is code duplication here but it helps with readability

            System.out.print("\nEnter 1st number of pair: ");
            while(!scan.hasNextInt()) {
                System.out.println("\nYou must provide a number.\n");
                System.out.print("Enter 1st number of pair: ");
                scan.next();
            }
            numberPairs[queryCount][0] = scan.nextInt();

            System.out.printf("Enter 2nd number of pair: ");
            while(!scan.hasNextInt()) {
                System.out.println("\nYou must provide a number.\n");
                System.out.printf("Enter 2nd number of pair: ");
                scan.next();
            }
            numberPairs[queryCount][1] = scan.nextInt();
        }

        return numberPairs;
    }


    public static void main(String args[]) {
        // Get number pairs from the user
        int[][] numberPairs = getUserInput();
    }
}

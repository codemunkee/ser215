/**
 * Created by Russell Nealis on 5/28/16 for SER 215 at ASU (ASSIGNMENT 4).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */
import java.util.Scanner;

public class MeanDeviationCalc {
    private static double[] getNumbers() {
        /*
        We collect a defined amount of numbers from the user
        and then return it as an array for further calculations.
        */

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the size of the number set you " +
                         "wish to solve for: ");
        while(!scan.hasNextInt()) {
            System.out.println("\nYou must provide an integer for the " +
                               "size of the input set.\n");
            System.out.print("Please enter the size of the number set you " +
                    "wish to enter: ");
            scan.next();
        }

        int setSize = scan.nextInt();

        // holds our user's entered numbers
        double[] numbers = new double[setSize];

        // get the numbers from he user
        for (int queryCount = 0; queryCount < setSize; queryCount++) {
            System.out.printf("Enter number (%s/%s): ", queryCount + 1, setSize);
            while(!scan.hasNextDouble()) {
                System.out.println("\nYou must provide a number.\n");
                System.out.printf("Enter number (%s/%s): ", queryCount + 1, setSize);
                scan.next();
            }
            numbers[queryCount] = scan.nextDouble();
        }

        return numbers;
    }

    public static double getMean(double[] numbers) {
        /*
        Returns the mean (average) for an array of numbers.
         */

        // sum up all of the numbers
        double sum = 0;
        for (double num : numbers) {
           sum += num;
        }

        // take the sum of the numbers and divide it by the length of the set
        return sum / numbers.length;

    }

    public static double getStdDev(double[] numbers) {
        /*
        Returns the standard deviation for an array of numbers
         */

        // mean of the set
        double mean = getMean(numbers);

        // an array for holding the squared difference from the mean
        double[] diffMean = new double[numbers.length];

        // for each value we find the square of the difference from teh mean
        for (int numbersPtr = 0; numbersPtr < numbers.length; numbersPtr++) {
            diffMean[numbersPtr] =  Math.pow(numbers[numbersPtr] - mean, 2);
        }

        // sum of the difference from the mean
        double sumOfDiffMean = 0;

        // add up all of the differences
        for (double diff : diffMean) {
           sumOfDiffMean += diff;
        }

        // finally, divide by the number of data points and take the square root
        // Note: notice that we divide by the length of set MINUS 1, this gives
        // us standard deviation and not POPULATION standard deviation
        return Math.sqrt(sumOfDiffMean/(numbers.length - 1));
    }

    public static void main(String args[]){
        double[] numbers = getNumbers();
        System.out.println("\nMean: " + getMean(numbers));
        System.out.println("Standard Deviation: " + getStdDev(numbers));
    }
}

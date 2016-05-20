
/**
 * Created by Russell Nealis on 5/18/16 for SER 215 at ASU (ASSIGNMENT 1).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */

public class PalindromicPrimes {
    /* Prints formatted list of palindromic prime numbers */
    private static void printPalindromicPrimes(int[] primes) {
        for (int primeElement = 0; primeElement < primes.length; primeElement++) {
            // we print 10 prime numbers per row
            if (primeElement % 10 == 0) {
                System.out.println();
            }
            // we pad the strings so that they always consume 6 characters
            System.out.print(String.format("%-6s", Integer.toString(primes[primeElement]) + " "));
        }
        // Final newline
        System.out.println();
    }

    /* Returns an array of Palindromic Primes */
    private static int[] getPPrimes(int numberOfPrimes) {

        // primitive integer array for storing palindromic primes
        int[] palPrimes = new int[numberOfPrimes];

        // a pointer for the element in our palindromic prime array that
        // we insert into
        int palPrimeElement = 0;

        // keep counting up integers until our palindromic prime array is full
        // ** note we start at 2, 1 is not a prime number **
        for (int count = 2; palPrimeElement < numberOfPrimes; count++) {
            if (isPrime(count) && isPalindrome(count)) {
                palPrimes[palPrimeElement] = count;
                palPrimeElement++;
            }
        }

        return palPrimes;
    }

    /* Check whether an integer is a palindrome */
    private static boolean isPalindrome(int n) {
        // reverse the integer and compare it to the original integer,
        // if not equal, its not a palindrome, otherwise it is

        return n == reverseInt(n) ? true : false;
    }

    /* Reverse an integer */
    private static int reverseInt(int n) {
        // integer for holding our reversed number
        int reverse = 0;

        // works through each position in the integer to reverse it
        while (n != 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }

    /* Check whether an integer is prime */
    private static boolean isPrime(int n) {
        // Check if the integer is evenly divisible by 2 and not 2
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        // check against odd integers, start at 3, increment by 2
        // while the tested divisor times itself is less than the
        // integer being tested
        for(int i = 3; i * i <= n; i += 2) {
            // if it's divisible, not prime
            if(n % i == 0)
                return false;
        }
        // otherwise it's prime
        return true;
    }

    private static int validateNumberOfPrimes(String args[]) {
        // This method allows us to validate that the arguments passed
        // to the tool are valid. In particular we're interested if a
        // a number of palindromic primes is provided and whether or not
        // the number provided makes sense

        int numberOfPrimes = 0;

        if (args.length > 0) {
            numberOfPrimes = Integer.parseInt(args[0]);
        } else {
            System.out.println("You need to provide a number of palindromic " +
                               "primes you want to print.");
            System.exit(1);
        }

        if (numberOfPrimes <= 0) {
            System.out.println("It's only worthwhile to look for a number of " +
                               "primes greater than 0.");
            System.exit(1);
        } else if (numberOfPrimes >= 500) {
            // We warn the user here because this could potentially
            // involve quite a bit of CPU time
            System.out.println("WARNING: Looking for more than 500 palindromic " +
                               "primes can be time consuming!");
        }

        return numberOfPrimes;

    }

    public static void main(String args[]) {
        // validate the number of primes the user wants us to identify
        int numberOfPrimes = validateNumberOfPrimes(args);
        // Gets an array of palindromic primes up to the number the user asks for
        int[] palindromicPrimes = getPPrimes(numberOfPrimes);
        // then "pretty" prints the palindromic primes
        printPalindromicPrimes(palindromicPrimes);
    }
}

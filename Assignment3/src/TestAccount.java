/**
 * Created by Russell Nealis on 5/24/16 for SER 215 at ASU (ASSIGNMENT 3).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */

import java.util.Scanner;

public class TestAccount {

    private static int getAccountID() {
        /* Gets and verifies an integer account ID */
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter an account ID: ");
        while (!scan.hasNextInt()) {
            System.out.println("\nAccount ID must be an integer.\n");
            System.out.print("Please enter an account ID: ");
            scan.next();
        }
        return scan.nextInt();
    }

    private static double getDoubleValue(String valueName) {
        /* Gets and verifies an double value, string must be supplied
         * for use when querying user for a specific type of value
         * (e.g. account balance) */
        Scanner scan = new Scanner(System.in);

        System.out.printf("Please enter a %s: ", valueName);
        while (!scan.hasNextDouble()) {
            System.out.printf("\n%s must be a floating point number.\n\n", valueName);
            System.out.printf("Please enter a %s: ", valueName);
            scan.next();
        }
        return scan.nextDouble();
    }

    private static void printAccountStatus(Account account) {
        /* Print out basic information about the account */
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Monthly Interest: " + account.getMonthlyInterest());
        System.out.println("Date Created: " + account.getDateCreated().toString());
    }

    public static void main(String args[]) throws java.lang.InterruptedException {
        /* This lets us interact with the Account, Checking, and Savings classes
        *  to verify their functionality */

        System.out.println("Please provide some information to create checking account.");
        Checking checkingAccount = new Checking(getAccountID(),
                                                getDoubleValue("Balance"),
                                                getDoubleValue("Annual Interest Rate"));
        System.out.println("\nPlease provide some information to create savings account.");
        Savings savingsAccount = new Savings(getAccountID(),
                                             getDoubleValue("Balance"),
                                             getDoubleValue("Annual Interest Rate"));

        /* Withdraw and Deposit into the two accounts. */

        System.out.println("\n## Withdraw from the checking account.\n");
        checkingAccount.withdraw(getDoubleValue("withdrawal amount"));
        System.out.println("\n## Deposit into the checking account.\n");
        checkingAccount.deposit(getDoubleValue("deposit amount"));

        System.out.println("\n## Withdraw from the savings account.\n");
        savingsAccount.withdraw(getDoubleValue("withdrawal amount"));
        System.out.println("\n## Deposit into the savings account.\n");
        savingsAccount.deposit(getDoubleValue("deposit amount"));

        /* Print out some information about the accounts */

        System.out.printf("\n#\n## Checking Account Status\n#\n\n");
        printAccountStatus(checkingAccount);
        System.out.printf("\n#\n## Savings Account Status\n#\n\n");
        printAccountStatus(savingsAccount);
    }
}

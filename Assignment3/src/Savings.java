/**
 * Created by Russell Nealis on 5/24/16 for SER 215 at ASU (ASSIGNMENT 3).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */

public class Savings extends Account {
    public Savings() {
        // Note: If a constructor does not explicitly invoke a superclass
        // constructor, the Java compiler automatically inserts a call to
        // the no-argument constructor of the superclass.
    }

    public Savings(int accountId, double balance, double annualInterestRate) {
        // call the Account constructor to set account ID, balance, annual interest rate
        super(accountId, balance, annualInterestRate);
    }

    @Override
    public double withdraw(double withdrawAmount) {
        /* We override the default withdraw method provided by the parent class
           so that we can protect a savings account from being overdrawn. We
           return the balance at the end of the operation.
        */
        if ((getBalance() - withdrawAmount) < 0) {
            System.out.printf("Sorry, withdrawing $%s from account " +
                              "would result in an overdrawn balance.\n", withdrawAmount);
        } else {
            super.withdraw(withdrawAmount);
        }
        return getBalance();
    }
}

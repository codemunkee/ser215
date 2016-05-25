import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rnealis on 5/24/16.
 */
public class Account {
    private int accountId;
    protected double balance;
    private double annualInterestRate;
    private Date dateCreated;

    Account() {
        /* default constructor:
           we generate a random account ID;
           balance and annualInterestRate default to 0.00 by the compiler */
        this.accountId = generateAccountID();
        this.dateCreated = new Date();
    }

    Account(int accountId, double balance, double annualInterestRate) {
        /* allows for the account to be initialized with an account ID,
           balance, and annual interest rate.
         */
        this.accountId = accountId;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    /* Getters and Setters */

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        // annual interest rate should be a decimal, e.g.
        // .01 = 1%
        // .1 = 10%
        // 1.0 = 100%
        this.annualInterestRate = annualInterestRate;
    }

    /* Some utility methods */

    public double getMonthlyInterest() {
        /* this method returns the amount of interest the account will earn
           over the course of a month. we use a Simple Interest formula
           based on the amount of money in the account */
        return  balance * annualInterestRate / 12.0;
    }

    public double withdraw(double withdrawAmount) {
        /* this method will withdraw funds from the account and
           return the new balance */
        balance = balance - withdrawAmount;
        return balance;
    }

    public double deposit(double depositAmount) {
        /* Deposit funds into the account and return the new balance */
        balance = balance + depositAmount;
        return balance;
    }

    public double deposit(int depositAmount) {
        /* Deposit whole (integer) dollar amount funds into the account and return the new balance */
        balance = balance + depositAmount;
        return balance;
    }

    private int generateAccountID() {
        /* this creates a random account ID for a user. It's important
           that if this method gets used that the caller verifies that
           the account id doesn't collide with another account before
           moving on. The ThreadLocalRandom method is the preferred way
           to generate random numbers in Java 8. We generate account IDs
           between 1000 and 9999. */
        return ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
    }

}






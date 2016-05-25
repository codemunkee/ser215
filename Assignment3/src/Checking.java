/**
 * Created by rnealis on 5/24/16.
 */

public class Checking extends Account {
    public Checking() {
        // Note: If a constructor does not explicitly invoke a superclass
        // constructor, the Java compiler automatically inserts a call to
        // the no-argument constructor of the superclass.
    }

    public Checking(int accountId, double balance, double annualInterestRate) {
        // call the Account constructor to set account ID, balance, annual interest rate
        super(accountId, balance, annualInterestRate);
    }
}

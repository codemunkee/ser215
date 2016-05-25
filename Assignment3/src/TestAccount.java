import static java.lang.Thread.sleep;

/**
 * Created by rnealis on 5/24/16.
 */
public class TestAccount {
    public static void main(String args[]) throws java.lang.InterruptedException {
        Account account = new Account();

        System.out.println(account.getAccountId());
        System.out.println(account.getDateCreated());

        System.out.println(account.getAnnualInterestRate());
        System.out.println(account.getBalance());
        account.setBalance(1000);
        account.setAnnualInterestRate(.01);
        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterest());
        account.withdraw(500.24);
        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterest());
        account.deposit(5);
        account.deposit(5.25);
        System.out.println(account.getBalance());

        System.out.println("Now Checking");
        Checking checking = new Checking();
        Checking checking2 = new Checking(1234, 0.1, 23);


        System.out.println(checking.getBalance());
        System.out.println(checking2.getBalance());


    }
}

/**
 * Created by Russell Nealis on 5/24/16 for SER 215 at ASU (ASSIGNMENT 3).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */

Account, Checking, Savings, TestAccount
------------------

The included code demonstrates:

• Creating classes
• Creating subclasses
• Inheriting data and methods
• Overloading methods
• Overriding methods
• Invoking constructor of the superclass
• Use of the keyword super


Things to know
===============
- This must be compiled with Java 8. It uses the Java 8 recommended way for generating
  random numbers that may not be supported on older versions of Java.
- There is no protection from creating account IDs of the same number. You can
  potentially have an account, checking, and savings object instantiated with
  the same account ID (not distinct). In a real application this would be a big problem.
- When you enter an interest rate, it expects a percentage to be entered. That is, if
  the account earns 3% interest, then "3" should be entered, not "0.03." I originally
  wrote in the latter way but decided doing so made it more confusing.
- If you have a negative account value, it will report a negative interest rate (this
  might be closer to how it would work in real-life, but be aware.)


* To Build *
javac TestAccount.java

* To Run *
java TestAccount

ex: user$ java TestAccount
Please provide some information to create checking account.
Please enter an account ID: 200
Please enter a Balance: 350.00
Please enter a Annual Interest Rate: 3

Please provide some information to create savings account.
Please enter an account ID: 300
Please enter a Balance: 100
Please enter a Annual Interest Rate: 5.2

## Withdraw from the checking account.

Please enter a withdrawal amount: 100

## Deposit into the checking account.

Please enter a deposit amount: 200

## Withdraw from the savings account.

Please enter a withdrawal amount: 0

## Deposit into the savings account.

Please enter a deposit amount: 0

#
## Checking Account Status
#

Current Balance: 450.0
Monthly Interest: 1.125
Date Created: Wed May 25 20:12:43 PDT 2016

#
## Savings Account Status
#

Current Balance: 100.0
Monthly Interest: 0.43333333333333335
Date Created: Wed May 25 20:12:54 PDT 2016

/**
 * Created by Russell Nealis on 5/18/16 for SER 215 at ASU (ASSIGNMENT 1).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 */

EmployeeWorkHours
------------------

This is a simple tool that sorts the number of hours worked by each employee
in descending order. It first prompts the user for the number of employees
and the number of work days in the week. Then for each employee the user is
prompted for an employee name and the number of hours worked on each work day.
Following the user's input a sorted list of hours worked by employee is printed.

There is basic validation on the number of employees (only integers) and work days
(only integers, no more than 7). The tool will also validate that the number of
hours worked each day (only integers, no more than 24 hours).


* To Build *
javac EmployeeWorkHours.java

* To Run *
java EmployeeWorkHours

ex: user$ java EmployeeWorkHours
Please enter the number of employees: 3
Please enter the number of work days: 3

Number of Employees: 3
Number of Working Days: 3

Please enter the name of the employee: Russ
Please enter the number of hours worked (day 1): 1
Please enter the number of hours worked (day 2): 2
Please enter the number of hours worked (day 3): 3

Please enter the name of the employee: Tina
Please enter the number of hours worked (day 1): 4
Please enter the number of hours worked (day 2): 5
Please enter the number of hours worked (day 3): 6

Please enter the name of the employee: Sonny
Please enter the number of hours worked (day 1): 0
Please enter the number of hours worked (day 2): 12
Please enter the number of hours worked (day 3): 8

Sonny worked 20 hours.
Tina worked 15 hours.
Russ worked 6 hours.

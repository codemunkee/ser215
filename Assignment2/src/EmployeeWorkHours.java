/**
 * Created by Russell Nealis on 5/18/16 for SER 215 at ASU (ASSIGNMENT 2).
 * Student ID: 1001059180 / 2016SummerA-X-SER215-46716
 *
 * This application prompts a user for a number of employees, and number of
 * days worked. For each employee, the user is prompted for the hours
 * worked by each employee. It then tallies up the total hours worked and
 * prints back a list of all of the employees sorted by the amount of hours
 * worked, from highest to lowest.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// We implement Comparable so we can more easily
// sort the employees by the number of hours worked
class Employee implements Comparable<Employee> {
    /* Object representation of employees */

    private String name;
    private int[] hours;
    private int totalHours = 0;

    Employee(String name, int[] hours) {
        this.name = name;
        this.hours = hours;
        this.totalHours = calculateTotalHours();
    }

    // we set the name with the constructor, so
    // only need a getter for the name
    String getName() {
        return name;
    }

    // return the total number of hours an employee has
    // worked over the course of a week
    int getTotalHours() {
        return totalHours;
    }

    // Calculates the total hours an employee has worked
    private int calculateTotalHours() {
        for (int dailyHours : hours) {
            totalHours += dailyHours;
        }
        return totalHours;
    }

    // this allows us to compare one employees hours to another
    // for the purposes of sorting
    @Override
    public int compareTo(final Employee employee) {
        return Integer.compare(this.totalHours, employee.totalHours);
    }
}

public class EmployeeWorkHours {
    /* Used for presenting and collecting information about
       employee work hours. The majority of the class is
       built for collecting and verifying information input
       by the user. Data collected is stored in Employee objects
     */

    private static int getEmployeeCount(Scanner scan){
        // Get the number of employees that we need to
        // calculate hours for.

        System.out.print("Please enter the number of employees: ");

        // until we get an integer, keep prompting
        while (!scan.hasNextInt()) {
            System.out.println("\nSorry, I need an integer.\n");
            System.out.print("Please enter the number of employees: ");
            scan.nextLine();
        }

        int numberOfEmployees = scan.nextInt();

        // skip to the next line
        scan.nextLine();

        return numberOfEmployees;
    }

    private static String getEmployeeName(Scanner scan){
        /* Get the name of an employee from the user */

        // we do this to move the scanner cursor
        System.out.print("Please enter the name of the employee: ");
        return scan.nextLine();
    }

    private static int[] getEmployeeHours(Scanner scan, int daysWorked){
        /* Get a list of hours worked from the user */

        // array for holding hours
        int[] hours = new int[daysWorked];

        // for each day worked get the number of hours that have been worked
        // we check that the hours provided is an integer between 0-24
        int daysCounted = 0;
        while (daysCounted != daysWorked) {

            System.out.print("Please enter the number of hours worked (day " +
                    (daysCounted + 1) + "): ");

            // until we get an integer, keep prompting
            while (!scan.hasNextInt()) {
                System.out.println("\nSorry, I need an integer.\n");
                System.out.print("Please enter the number of hours worked (day " +
                        (daysCounted + 1) + "): ");
                scan.nextLine();
            }

            int hoursWorked = scan.nextInt();

            // if the hours input does not make sense, prompt again
            if (hoursWorked < 0 | hoursWorked > 24) {
                System.out.println("\nHours worked must be between 0 and 24\n");
            } else {
                hours[daysCounted] = hoursWorked;
                daysCounted++;
            }
        }
        // move to the next line
        scan.nextLine();
        // just an extra space for some padding
        System.out.println();
        return hours;
    }

    private static int getWorkingDays(Scanner scan){
        // Get the number of working days that we collect hours for

        // variables for the number of days worked and a boolean for
        // letting us know where a valid input was provided.
        int numberOfDays;
        boolean validNumberOfDays;

        do {
            System.out.print("Please enter the number of work days: ");

            // until we get an integer, keep prompting
            while (!scan.hasNextInt()) {
                System.out.println("\nSorry, I need an integer.\n");
                System.out.print("Please enter the number of work days: ");
                scan.next();
            }

            numberOfDays = scan.nextInt();

            // we need to make sure that the number of days is great than 0
            // but also less than 8
            validNumberOfDays =  (numberOfDays > 0 && numberOfDays < 8);

            if (!validNumberOfDays) {
                System.out.println("\nYou must enter a number of days " +
                        "between 1 and 7.\n");
            }

        } while (!validNumberOfDays);
        // skip to the next line
        scan.nextLine();

        return numberOfDays;
    }

    public static void main(String args[]) {

        // Scanner object for getting various input
        Scanner scan = new Scanner(System.in);

        // Get the number of employees we want to tabulate hours for
        int numberOfEmployees = getEmployeeCount(scan);
        // Get the number of days per employee we want to tabulate hours for
        int workingDays = getWorkingDays(scan);

        System.out.println("\nNumber of Employees: " + numberOfEmployees);
        System.out.println("Number of Working Days: " + workingDays + "\n");

        // create an array list for holding of our employee objects
        ArrayList<Employee> employees = new ArrayList<>();

        // for each employee, create an object, query for their name and hours worked
        for (int employeeNum = 0; employeeNum < numberOfEmployees; employeeNum++) {
            Employee newEmployee = new Employee(getEmployeeName(scan),
                    getEmployeeHours(scan, workingDays));
            employees.add(newEmployee);
        }

        // sort the employees by hours worked, descending
        Collections.sort(employees, Collections.reverseOrder());

        // print out each employee's information -> name and hours worked
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " worked " +
                    employee.getTotalHours() + " hours.");
        }
    }
}

/**
 * Created by rnealis on 5/20/16.
 */
import java.util.Scanner;

class Employee {
    /* Object representation of employees */

    String name;
    int[] hours;

    public Employee(String name, int[] hours) {
        this.name = name;
        this.hours = hours;
    }
}

public class EmployeeWorkHours {
    /* Used for presenting and collecting information about
       employee work hours.
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
        // Get the name of an employee

        // we do this to move the scanner cursor
        System.out.print("Please enter the name of the employee: ");
        return scan.nextLine();
    }

    private static int[] getEmployeeHours(Scanner scan, int days){
        // Build an array with a list of the number of hours worked

        int[] hours = new int[days];

        // for each day worked get the number of hours that have been worked
        for (int daysCounted = 0; daysCounted < days; daysCounted++) {

            System.out.print("Please enter the number of hours worked (day " +
                             daysCounted + "): ");

            // until we get an integer, keep prompting
            while (!scan.hasNextInt()) {
                System.out.println("\nSorry, I need an integer.\n");
                System.out.print("Please enter the number of hours worked (day " +
                                 daysCounted + "): ");
                scan.nextLine();
            }
            hours[daysCounted] = scan.nextInt();
            // move to the next line
            scan.nextLine();

            daysCounted++;
        }
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
                System.out.println("\nYou must enter a number of days between 1 and 7.\n");
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

        System.out.println();
        System.out.println("Number of Employees: " + numberOfEmployees);
        System.out.println("Number of Working Days: " + workingDays);
        System.out.println();

        // array to hold our employee objects
        Employee employees[] = new Employee[numberOfEmployees];

        // for each employee, create an object for them, query
        for (int employeeNum = 0; employeeNum < numberOfEmployees; employeeNum++) {

            int[] bleh = new int[10];
            bleh[0] = 0;
            employees[employeeNum] = new Employee(getEmployeeName(scan),
                                                  getEmployeeHours(scan, workingDays));

            System.out.println(employees[employeeNum].name);
        }
    }
}

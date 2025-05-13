package org.example;

import model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeManagement {

    // Uses Singleton Design Pattern to ensure only one instance of
    // EmployeManagement exists, to avoid memory leaks.
    private static volatile EmployeManagement instance;

    // Constructors
    private Scanner scanner = new Scanner(System.in);
    private String filePath = "src/main/resources/EmployeeDetails.csv";
    private List<EmployeeModel> employeeList = new ArrayList<>();

    // Private constructor to prevent instantiation from outside
    public static EmployeManagement getInstance() {
        if (instance == null) {
            synchronized (EmployeManagement.class) {
                if (instance == null) {
                    instance = new EmployeManagement();
                }
            }
        }
        return instance;
    }

    // Load the menu
    public void intializeMenu() {

        // While true, once the user wont exit the program, the menu will be displayed
        while (true) {

            // GUI menu of the console
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to Motorcycle Service Center Employee");
            System.out.println("---------------------------------------------");
            System.out.println("Choose the following options (1-5):");
            System.out.println("1. View Employee");
            System.out.println("2. Hours Work Calculation");
            System.out.println("3. Gross Wage Calculation");
            System.out.println("4. Net Wage Calculation");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            // These are the options,each has different assigned methods
            switch (option) {
                case 1:

                    // This will load the employee data from the CSV file
                    LoadEmployeeData();
                    break;
                case 2:

                    // This will calculate the hours worked by the employee
                    HoursWorkCalculated();
                    break;
                case 3:

                    // This will calculate the gross wage of the employee
                    GrossWageCalculated();
                    break;
                case 4:

                    // This will calculate the net wage of the employee
                    NetWageCalculated();
                    break;
                case 5:

                    // Close the program
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:

                    // Error the program when user wont select an options
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Load the employee data from the CSV file
    private void LoadEmployeeData() {
        System.out.println("Loading employee data...");

        // get the employee data from the CSV file
        employeeList = EmployeeModel.loadFromCSV(filePath);

        // if the employee data is empty, it will display an error message
        if (employeeList.isEmpty()) {
            System.out.println("No employee data found.");
            return;
        }

        // Display the employee data in a formatted table
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                "ID", "Last Name", "First Name", "Birth Date", "Address", "Phone", "SSS", "TIN", "PhilHealth", "PagIbig",
                "Status", "Position", "Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
                "Gross Salary", "Hourly Rate");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        // Used for each employee in the list, it will display the employee data
        for (EmployeeModel employee : employeeList) {

          try{
              // Display the employee data in a formatted table
              System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
              System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                      employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getBirthDay(),
                      employee.getAddress().replace("\"", ""), employee.getPhoneNumber(), employee.getSssNumber(), employee.getTinNumber(),
                      employee.getPhilHealthNumber(), employee.getPagIbigNumber(), employee.getStatus(), employee.getPosition(),
                      employee.getIntermidate_supervisor().replace("\"", ""), employee.getBasicSalary().replace("\"", ""),
                      employee.getRice_subsidy().replace("\"", ""), employee.getPhoneAllowance().replace("\"", ""),
                      employee.getClothingAllowance().replace("\"", ""), employee.getGrossSemiMonthlySalary().replace("\"", ""),
                      employee.getHourlyRate());
          } catch (NumberFormatException e) {
              // Error message
              System.out.println("Error parsing employee data for ID: " + employee.getEmployeeId());
          }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // This method will calculate the hours worked by the employee
    private void HoursWorkCalculated() {
        System.out.println("Hours Work Calculation");

        // Check if the employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }


        // Display the employee data in a formatted table
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n", "ID", "Last Name", "First Name", "Hourly Rate", "Gross Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Used for each employee in the list, it will display the employee data
        for (EmployeeModel employee : employeeList) {
            try {
                // Calculate the hours worked by the employee
                EmployeeCalculator.getInstance().calculateHoursWorked(employee);
            } catch (NumberFormatException e) {

                // Error message
                System.out.println("Error parsing hourly rate for employee ID: " + employee.getEmployeeId());
            }
        }
    }

    // This method will calculate the gross wage of the employee
    private void GrossWageCalculated() {
        System.out.println("Gross Wage Calculation");

        // Check if the employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }

        // Display the employee data in a formatted table
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s%n", "ID", "Last Name", "First Name", "Gross Semi-Monthly Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Used for each employee in the list, it will display the employee data
        for (EmployeeModel employee : employeeList) {
            try {

                // Calculate the gross wage of the employee
                EmployeeCalculator.getInstance().calculateGrossWage(employee);
            } catch (NumberFormatException e) {

                // Error message
                System.out.println("Error parsing gross semi-monthly salary for employee ID: " + employee.getEmployeeId());
            }

        }
    }

    // This method will calculate the net wage of the employee
    private void NetWageCalculated() {
        System.out.println("Net Wage Calculation");

        // Check if the employee list is empty
        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }

        // Display the employee data in a formatted table
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n", "ID", "Last Name", "First Name", "Gross Salary", "Net Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Used for each employee in the list, it will display the employee data
        for (EmployeeModel employee : employeeList) {
         try{

             // Calculate the net wage of the employee
             EmployeeCalculator.getInstance().calculateNetWage(employee);
         } catch (NumberFormatException e) {

             // Error message
             System.out.println("Error parsing gross semi-monthly salary for employee ID: " + employee.getEmployeeId());
         }
        }
    }
}
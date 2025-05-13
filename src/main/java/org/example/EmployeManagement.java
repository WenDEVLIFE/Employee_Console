package org.example;

import model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeManagement {

    // Singleton instance to ensure only one instance of EmployeManagement exists avoid memory leak
    private static volatile  EmployeManagement instance;

    private int options = 0;

    private Scanner scanner = new Scanner(System.in);

    List<EmployeeModel> employeeList = new ArrayList<>();

    // Private constructor to prevent instantiation
    static EmployeManagement getInstance() {
        if (instance == null) {
            synchronized (EmployeManagement.class) {
                if (instance == null) {
                    instance = new EmployeManagement();
                }
            }
        }
        return instance;
    }

    // Constructure used to intialize the menu
    public void intializeMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to Motorcycle Service Center Employee");
        System.out.println("---------------------------------------------");
        System.out.println("Choose the following from options from (1-4)");
        System.out.println("1. View Employee");
        System.out.println("2. Hours Work Calculation");
        System.out.println("3. Gross Wage Calculation");
        System.out.println("4. Net Wage Calculation");
        System.out.println("5. Exit");

        int option =  scanner.nextInt();

        switch (option){
            case 1:
                LoadEmployeeData();
                break;
            case 2:
                System.out.println("Hours Work Calculation");
                break;
            case 3:
                System.out.println("Gross Wage Calculation");
                break;
            case 4:
                System.out.println("Net Wage Calculation");
                break;
            case 5:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

    }

    private void LoadEmployeeData(){
        System.out.println("Loading employee data...");
        String filePath = "src/main/resources/EmployeeDetails.csv";

        // Load employee data from CSV file
        System.out.println("List of Employee...");
        List<EmployeeModel> employees = EmployeeModel.loadFromCSV(filePath);
        if (employees.isEmpty()) {
            System.out.println("No employee data found.");
            return;
        }

        // Print table header
        System.out.printf("%-10s %-15s %-15s %-12s %-40s %-15s %-20s %-20s %-20s %-20s %-10s %-25s %-20s %-15s %-15s %-15s %-15s %-15s %-10s%n",
                "ID", "Last Name", "First Name", "Birth Date", "Address", "Phone", "SSS", "TIN", "PhilHealth", "PagIbig",
                "Status", "Position", "Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
                "Gross Salary", "Hourly Rate");

        // Print table rows
        for (EmployeeModel employee : employees) {
            System.out.printf("%-10s %-15s %-15s %-12s %-40s %-15s %-20s %-20s %-20s %-20s %-10s %-25s %-20s %-15s %-15s %-15s %-15s %-15s %-10s%n",
                    employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getBirthDay(),
                    employee.getAddress().replace("\"", ""), employee.getPhoneNumber(), employee.getSssNumber(), employee.getTinNumber(),
                    employee.getPhilHealthNumber(), employee.getPagIbigNumber(), employee.getStatus(), employee.getPosition(),
                    employee.getIntermidate_supervisor().replace("\"", ""), employee.getBasicSalary().replace("\"", ""),
                    employee.getRice_subsidy().replace("\"", ""), employee.getPhoneAllowance().replace("\"", ""),
                    employee.getClothingAllowance().replace("\"", ""), employee.getGrossSemiMonthlySalary().replace("\"", ""),
                    employee.getHourlyRate());
        }
    }
}

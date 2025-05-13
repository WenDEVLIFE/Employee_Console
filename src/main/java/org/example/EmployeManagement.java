package org.example;

import model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeManagement {

    private static volatile EmployeManagement instance;

    private Scanner scanner = new Scanner(System.in);
    private String filePath = "src/main/resources/EmployeeDetails.csv";
    private List<EmployeeModel> employeeList = new ArrayList<>();
    private double hoursWorked = 0.0;

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

    public void intializeMenu() {
        while (true) {
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

            switch (option) {
                case 1:
                    LoadEmployeeData();
                    break;
                case 2:
                    HoursWorkCalculated();
                    break;
                case 3:
                    GrossWageCalculated();
                    break;
                case 4:
                    NetWageCalculated();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void LoadEmployeeData() {
        System.out.println("Loading employee data...");
        employeeList = EmployeeModel.loadFromCSV(filePath);

        if (employeeList.isEmpty()) {
            System.out.println("No employee data found.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                "ID", "Last Name", "First Name", "Birth Date", "Address", "Phone", "SSS", "TIN", "PhilHealth", "PagIbig",
                "Status", "Position", "Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance",
                "Gross Salary", "Hourly Rate");

        for (EmployeeModel employee : employeeList) {
            System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                    employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getBirthDay(),
                    employee.getAddress().replace("\"", ""), employee.getPhoneNumber(), employee.getSssNumber(), employee.getTinNumber(),
                    employee.getPhilHealthNumber(), employee.getPagIbigNumber(), employee.getStatus(), employee.getPosition(),
                    employee.getIntermidate_supervisor().replace("\"", ""), employee.getBasicSalary().replace("\"", ""),
                    employee.getRice_subsidy().replace("\"", ""), employee.getPhoneAllowance().replace("\"", ""),
                    employee.getClothingAllowance().replace("\"", ""), employee.getGrossSemiMonthlySalary().replace("\"", ""),
                    employee.getHourlyRate());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void HoursWorkCalculated() {
        System.out.println("Hours Work Calculation");

        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }

        hoursWorked = 40; // Example: 40 hours per week
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n", "ID", "Last Name", "First Name", "Hourly Rate", "Gross Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        for (EmployeeModel employee : employeeList) {
            try {
                double hourlyRate = Double.parseDouble(employee.getHourlyRate());
                double grossSalary = hoursWorked * hourlyRate;

                System.out.printf("%-15s %-20s %-20s %-15.2f %-15.2f%n",
                        employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), hourlyRate, grossSalary);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            } catch (NumberFormatException e) {
                System.out.println("Error parsing hourly rate for employee ID: " + employee.getEmployeeId());
            }
        }
    }

    private void GrossWageCalculated() {
        System.out.println("Gross Wage Calculation");

        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s%n", "ID", "Last Name", "First Name", "Gross Semi-Monthly Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (EmployeeModel employee : employeeList) {
            try {
                double grossSemiMonthlySalary = Double.parseDouble(employee.getGrossSemiMonthlySalary());
                System.out.printf("%-15s %-20s %-20s %-15.2f%n",
                        employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), grossSemiMonthlySalary);
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            } catch (NumberFormatException e) {
                System.out.println("Error parsing gross salary for employee ID: " + employee.getEmployeeId());
            }
        }
    }

    private void NetWageCalculated() {
        System.out.println("Net Wage Calculation");

        if (employeeList.isEmpty()) {
            System.out.println("No employee data available. Please load employee data first.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s%n", "ID", "Last Name", "First Name", "Gross Salary", "Net Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        NetWageCalculator calculator = new NetWageCalculator();
        for (EmployeeModel employee : employeeList) {
            calculator.calculate(employee);
        }
    }
}
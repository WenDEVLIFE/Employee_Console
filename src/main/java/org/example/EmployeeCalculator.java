package org.example;

import impl.EmployeeOperations;
import model.EmployeeModel;
import model.SalaryCalculator;

public class EmployeeCalculator extends SalaryCalculator   implements EmployeeOperations {

    // Uses Singleton Design Pattern to ensure only one instance of
    // EmployeeCalculator exists, to avoid memory leaks.
    private static volatile EmployeeCalculator instance;

    // Private constructor to prevent instantiation from outside
    public static EmployeeCalculator getInstance() {
        if (instance == null) {
            synchronized (EmployeeCalculator.class) {
                if (instance == null) {
                    instance = new EmployeeCalculator();
                }
            }
        }
        return instance;
    }

    // This method calculates the hours worked by an employee.
    @Override
    public void calculateHoursWorked(EmployeeModel employee) {
        // Parse and retrieve the necessary components
        double hoursWorked = 40;

        ///  get the hourly rate from the model
        double hourlyRate = parseDouble(employee.getHourlyRate());

        // calculate the gross salary
        double grossSalary = hoursWorked * hourlyRate;

        //  set the gross salary in the model
        employee.setGrossSemiMonthlySalary(String.valueOf(grossSalary));
        // set the gross salary in the model
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15.2f%n",
                employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), grossSalary);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    // This method calculates the gross wage of an employee.
    @Override
    public void calculateGrossWage(EmployeeModel employee) {
        // Parse and retrieve the necessary components
        double grossSalary = parseDouble(employee.getGrossSemiMonthlySalary());
        double clothingAllowance = parseDouble(employee.getClothingAllowance());
        double riceSubsidy = parseDouble(employee.getRice_subsidy());
        double phoneAllowance = parseDouble(employee.getPhoneAllowance());

        // Calculate the total gross wage
        double totalGrossWage = grossSalary + clothingAllowance + riceSubsidy + phoneAllowance;

        // Display the result
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15.2f%n",
                employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), totalGrossWage);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // This method calculates the net wage of an employee.
    @Override
    public void calculateNetWage(EmployeeModel employee) {

        // get the necessary components from the Model from grossSalary, ClothingAllowance,
        // RiceSubsidy, and PhoneAllowance
        double grossSalary = parseDouble(employee.getGrossSemiMonthlySalary());
        double clothingAllowance = parseDouble(employee.getClothingAllowance());
        double riceSubsidy = parseDouble(employee.getRice_subsidy());
        double phoneAllowance = parseDouble(employee.getPhoneAllowance());

        // calculate the net salary
        double netSalary = grossSalary - (clothingAllowance + riceSubsidy + phoneAllowance);

        // GUI
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15.2f %-15.2f%n",
                employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), grossSalary, netSalary);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
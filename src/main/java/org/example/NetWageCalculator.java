package org.example;

import model.EmployeeModel;
import model.SalaryCalculator;

public class NetWageCalculator extends SalaryCalculator {
    @Override
    public void calculate(EmployeeModel employee) {
        double grossSalary = parseDouble(employee.getGrossSemiMonthlySalary());
        double clothingAllowance = parseDouble(employee.getClothingAllowance());
        double riceSubsidy = parseDouble(employee.getRice_subsidy());
        double phoneAllowance = parseDouble(employee.getPhoneAllowance());

        double netSalary = grossSalary - (clothingAllowance + riceSubsidy + phoneAllowance);

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-15.2f %-15.2f%n",
                employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), grossSalary, netSalary);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
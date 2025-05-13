package model;


public abstract class SalaryCalculator {

    // This class is responsible for calculating the salary of employees.
    public abstract void calculateHoursWorked(EmployeeModel employee);

    // This method calculates the gross wage of an employee.
    public abstract void calculateGrossWage(EmployeeModel employee);

    //  This method calculates the net wage of an employee.
    public abstract void calculateNetWage(EmployeeModel employee);

    // This method parses a string to a double value.
    protected double parseDouble(String value) {
        return utils.DataParser.parseDouble(value);
    }
}

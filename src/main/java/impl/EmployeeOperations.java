package impl;

import model.EmployeeModel;

// This interface defines the operations for employee management.
public interface EmployeeOperations {

    // Method signatures for employee operations
    void calculateHoursWorked(EmployeeModel employee);

    // Method to calculate gross wage
    void calculateGrossWage(EmployeeModel employee);

    // Method to calculate net wage
    void calculateNetWage(EmployeeModel employee);

}

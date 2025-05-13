package model;


public abstract class SalaryCalculator {
    public abstract void calculate(EmployeeModel employee);

    protected double parseDouble(String value) {
        return utils.DataParser.parseDouble(value);
    }
}

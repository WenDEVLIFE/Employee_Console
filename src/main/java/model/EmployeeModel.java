package model;

public class EmployeeModel {

    private String employeeId;

    private String lastName;

    private String firstName;

   private String birthDay;

   private String address;

   private String phoneNumber;

   private String sssNumber;

   private String tinNumber;

   private String philHealthNumber;

    private String pagIbigNumber;

    private String status;

    private String position;

    private String intermidate_supervisor;

    private String basicSalary;

    private String rice_subsidy;

    private String phoneAllowance;

    private String clothingAllowance;

    private String grossSemiMonthlySalary;

    private String hourlyRate;

    public EmployeeModel(String employeeId, String lastName, String firstName, String birthDay, String address,
            String phoneNumber, String sssNumber, String tinNumber, String philHealthNumber, String pagIbigNumber,
            String status, String position, String intermidate_supervisor, String basicSalary, String rice_subsidy,
            String phoneAllowance, String clothingAllowance, String grossSemiMonthlySalary, String hourlyRate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.tinNumber = tinNumber;
        this.philHealthNumber = philHealthNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.status = status;
        this.position = position;
        this.intermidate_supervisor = intermidate_supervisor;
        this.basicSalary = basicSalary;
        this.rice_subsidy = rice_subsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlySalary = grossSemiMonthlySalary;
        this.hourlyRate = hourlyRate;
    }

    // Get the employee ID
    public String getEmployeeId() {
        return employeeId;
    }

    // Set the employee ID
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Get the last name
    public String getLastName() {
        return lastName;
    }

    // Set the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get the first name
    public String getFirstName() {
        return firstName;
    }

    // Set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // get the birth date
    public String getBirthDay() {
        return birthDay;
    }

    // Set the birth date
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    // Get the address
    public String getAddress() {
        return address;
    }

    // Set the address
    public void setAddress(String address) {
        this.address = address;
    }

    // Get the phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set the phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get the SSS number
    public String getSssNumber() {
        return sssNumber;
    }

    // Set the SSS number
    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    // Get the TIN number
    public String getTinNumber() {
        return tinNumber;
    }

    // Set the TIN number
    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    // Get the PhilHealth number
    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    // Set the PhilHealth number
    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    // Get the Pag-Ibig number
    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    // Set the Pag-Ibig number
    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    // Get the status
    public String getStatus() {
        return status;
    }

    // Set the status
    public void setStatus(String status) {
        this.status = status;
    }

    // Get the position
    public String getPosition() {
        return position;
    }

    // Set the position
    public void setPosition(String position) {
        this.position = position;
    }

    // Get the intermediate supervisor
    public String getIntermidate_supervisor() {
        return intermidate_supervisor;
    }

    // Set the intermediate supervisor
    public void setIntermidate_supervisor(String intermidate_supervisor) {
        this.intermidate_supervisor = intermidate_supervisor;
    }

    // Get the basic salary
    public String getBasicSalary() {
        return basicSalary;
    }

    // Set the basic salary
    public  String getRice_subsidy() {
        return rice_subsidy;
    }

    // Set the basic salary
    public void setRice_subsidy(String rice_subsidy) {
        this.rice_subsidy = rice_subsidy;
    }

    // Get the rice subsidy
    public String getPhoneAllowance() {
        return phoneAllowance;
    }

    // Set the phone allowance
    public void setPhoneAllowance(String phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    // Get the clothing allowance
    public String getClothingAllowance() {
        return clothingAllowance;
    }

    // Set the clothing allowance
    public void setClothingAllowance(String clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    // Get the basic salary
    public String getGrossSemiMonthlySalary() {
        return grossSemiMonthlySalary;
    }

    // Set the gross semi-monthly salary
    public void setGrossSemiMonthlySalary(String grossSemiMonthlySalary) {
        this.grossSemiMonthlySalary = grossSemiMonthlySalary;
    }

    // Get the hourly rate
    public String getHourlyRate() {
        return hourlyRate;
    }

    // Set the hourly rate
    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Override the toString method to display the employee information
    @Override
    public String toString() {
        return "EmployeeModel [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName
                + ", birthDay=" + birthDay + ", address=" + address + ", phoneNumber=" + phoneNumber + ", sssNumber="
                + sssNumber + ", tinNumber=" + tinNumber + ", philHealthNumber=" + philHealthNumber
                + ", pagIbigNumber=" + pagIbigNumber + ", status=" + status + ", position=" + position
                + ", intermidate_supervisor=" + intermidate_supervisor + ", basicSalary=" + basicSalary
                + ", rice_subsidy=" + rice_subsidy + ", phoneAllowance=" + phoneAllowance + ", clothingAllowance="
                + clothingAllowance + ", grossSemiMonthlySalary=" + grossSemiMonthlySalary
                + ", hourlyRate=" + hourlyRate + "]";
    }


}

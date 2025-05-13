package org.example;


public class Main {
    public static void main(String[] args) {

        // Added try catch block to handle exceptions
        try{
            // Create an instance of EmployeManagement than using objects
            EmployeManagement.getInstance().intializeMenu();
        } catch (Exception e) {
            // Handle any exceptions that may occur during initialization
            System.out.println("An error occurred during initialization: " + e.getMessage());
        }
    }
}
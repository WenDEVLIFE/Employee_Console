package org.example;

import java.util.Scanner;

public class EmployeManagement {

    // Singleton instance to ensure only one instance of EmployeManagement exists avoid memory leak
    private static volatile  EmployeManagement instance;

    private int options = 0;

    private Scanner scanner = new Scanner(System.in);

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
                System.out.println("View Employee");
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
}

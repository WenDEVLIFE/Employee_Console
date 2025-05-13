package org.example;

public class EmployeManagement {
    private static volatile  EmployeManagement instance;

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

    public void intializeMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to Motorcycle Service Center Employee");
        System.out.println("---------------------------------------------");

    }
}

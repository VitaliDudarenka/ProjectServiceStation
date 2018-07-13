package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.CustomerBase;

import java.util.Scanner;

public class Menu {
    private CustomerBase customerBase;
    private InfoOutput infoOutput;

    public Menu(CustomerBase customerBase, InfoOutput infoOutput) {
        this.customerBase = customerBase;
        this.infoOutput = infoOutput;
    }

    private void startMenu() {
        System.out.println("\n(1) Search by surname\n(2) Search by region of car\n(3) Show info\n(4) Sort by name\n(5) Sort by date of last order\n(6) Exit ");
        Scanner scn = new Scanner(System.in);
        try {
            int input = scn.nextInt();
            if (input == 1)
                customerBase.searchCustomerByName();
            else if (input == 2)
                customerBase.searchCustomerByCar();
            else if (input == 3) {
                infoOutput.currentBirthdayList();
                infoOutput.notAppealList();
                infoOutput.percentOfDiscount();
            } else if (input == 4)
                customerBase.printByName();
            else if (input == 5)
                customerBase.printByDate();
            else if (input == 6)
                System.exit(0);
            else
                System.out.println("Incorrect input");
        } catch (java.util.InputMismatchException e) {
            System.err.println("Incorrect input");
        }
    }

    public void exec() {
        while (true)
            startMenu();
    }
}

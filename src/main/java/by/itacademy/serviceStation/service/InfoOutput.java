package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.CustomerBase;

public class InfoOutput {
    private CustomerBase customers;
    private InfoCalculate infoCalculate;

    public InfoOutput(CustomerBase customers, InfoCalculate infoCalculate) {
        this.customers = customers;
        this.infoCalculate = infoCalculate;
    }

    public void currentBirthdayList() {
        System.out.println("Birthdays in current month:");
        System.out.println(infoCalculate.currentBirthdayList().toString());
        System.out.println();
    }

    public void notAppealList() {
        System.out.println("No appeals for 6 months:");
        System.out.println(infoCalculate.notAppealList().toString());
        System.out.println();
    }

    public void percentOfDiscount() {
        System.out.println("Percent of discount customers: " + infoCalculate.percentOfDiscount() + "%");
    }
}

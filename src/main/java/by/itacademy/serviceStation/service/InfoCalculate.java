package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;

import java.time.LocalDate;

public class InfoCalculate implements Info {
    private CustomerBase customers;

    public InfoCalculate(CustomerBase customers) {
        this.customers = customers;
    }

    @Override
    public CustomerBase currentBirthdayList() {
        CustomerBase customerBase = new CustomerBase();
        for (Customer customer : customers.getCustomerSet()) {
            if (customer.getDateOfBirth().getMonth() == LocalDate.now().getMonth())
                customerBase.add(customer);
        }
        return customerBase;
    }

    @Override
    public CustomerBase notAppealList() {
        CustomerBase customerBase = new CustomerBase();
        for (Customer customer : customers.getCustomerSet()) {
            if (customer.getLastOrder().plusMonths(6).isBefore(LocalDate.now()))
                customerBase.add(customer);
        }
        return customerBase;
    }

    @Override
    public double percentOfDiscount() {
        double count = 0;
        double countDiscount = 0;
        for (Customer customer : customers.getCustomerSet()) {
            if (customer.isDiscount())
                countDiscount++;
            count++;
        }
        return countDiscount / count * 100;
    }
}

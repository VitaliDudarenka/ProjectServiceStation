package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.Cars;
import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;

import java.util.regex.Pattern;

public class SearchCustomerCalculate implements Search {
    private CustomerBase customers;
    private Cars cars = new Cars();
    private static final String REGEX = "\\s*(\\s|=>|,)\\s*";

    public SearchCustomerCalculate(CustomerBase customers) {
        this.customers = customers;
    }

    @Override
    public CustomerBase searchByName(String surname) {
        CustomerBase customerBase = new CustomerBase();
        for (Customer customer : customers.getCustomerSet()) {
            if (getSurname(customer.getName()).equalsIgnoreCase(surname)) {
                customerBase.add(customer);
            }
        }
        return customerBase;
    }

    @Override
    public CustomerBase searchByCar(String region) {
        CustomerBase customerBase = new CustomerBase();
        cars.initializeList();
        for (Customer customer : customers.getCustomerSet()) {
            customerBase.addAll(checkCarList(customer, region).getCustomerSet());
        }
        return customerBase;
    }

    private CustomerBase checkCarList(Customer customer, String region) {
        CustomerBase customerBase = new CustomerBase();
        int count = 0;
        for (String car : customer.getCar()) {
            for (String carSearched : cars.search(region)) {
                if (carSearched.equals(car) && count == 0) {
                    customerBase.add(customer);
                    count++;
                }
            }
        }
        return customerBase;
    }

    public String getSurname(String nameSurname) {
        final Pattern p = Pattern.compile(REGEX);
        final String[] items = p.split(nameSurname);
        String surname = "";
        for (final String s : items) {
            surname = s;
        }
        return surname;
    }
}

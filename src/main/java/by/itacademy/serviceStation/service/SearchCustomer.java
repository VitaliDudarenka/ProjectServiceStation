package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.service.exceptions.NameInputException;

import java.util.Scanner;
import java.util.Set;

public class SearchCustomer {
    private Set<Customer> customers;
    private final Scanner scanner = new Scanner(System.in);
    private SearchCustomerCalculate searchCustomerCalculate;

    public SearchCustomer(Set<Customer> customers, SearchCustomerCalculate searchCustomerCalculate) {
        this.customers = customers;
        this.searchCustomerCalculate = searchCustomerCalculate;
    }

    public void searchByName() throws NameInputException {
        System.out.println("Enter surname");
        String name = scanner.nextLine();
        String[] nameArr = name.split(" ");
        if (nameArr.length != 1)
            throw new NameInputException("Enter only SURNAME");
        if (searchCustomerCalculate.searchByName(name).getCustomerSet().size() > 0)
            System.out.println(searchCustomerCalculate.searchByName(name).toString());
        else System.out.println("not found");
    }

    public void searchByCar() {
        System.out.println("Enter region of car");
        String region = scanner.nextLine();
        if (searchCustomerCalculate.searchByCar(region).getCustomerSet().size() > 0)
            System.out.println(searchCustomerCalculate.searchByCar(region));
        else System.out.println("not found");
    }

}

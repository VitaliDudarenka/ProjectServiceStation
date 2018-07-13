package by.itacademy.serviceStation.domain;

import by.itacademy.serviceStation.service.SearchCustomer;
import by.itacademy.serviceStation.service.SearchCustomerCalculate;
import by.itacademy.serviceStation.service.comparators.NameComparator;
import by.itacademy.serviceStation.service.comparators.OrderDateComparator;
import by.itacademy.serviceStation.service.exceptions.NameInputException;

import java.util.Set;
import java.util.TreeSet;

public class CustomerBase {
    private Set<Customer> customers = new TreeSet<>(new NameComparator());
    private Set<Customer> customersByDate = new TreeSet<>(new OrderDateComparator());
    private SearchCustomerCalculate searchCustomerCalculate = new SearchCustomerCalculate(this);
    private SearchCustomer searchCustomer = new SearchCustomer(customers, searchCustomerCalculate);

    public Set<Customer> getCustomerSet() {
        return customers;
    }

    public void add(Customer customer) {
        this.customers.add(customer);
    }

    public void addAll(Set<Customer> customers) {
        this.customers.addAll(customers);
    }

    @Override
    public String toString() {
        return "" + customers + "";
    }

    public void printByName() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public void printByDate() {
        customersByDate.addAll(customers);
        for (Customer customer : customersByDate) {
            System.out.println(customer.toString());
        }
    }

    public void searchCustomerByName() {
        try {
            searchCustomer.searchByName();
        } catch (NameInputException e) {
            System.err.println(e);
        }
    }

    public void searchCustomerByCar() {
        searchCustomer.searchByCar();
    }

}

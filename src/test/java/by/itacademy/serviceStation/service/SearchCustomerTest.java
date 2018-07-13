package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class SearchCustomerTest {
    private CustomerBase customerBase = new CustomerBase();
    private SearchCustomerCalculate searchCustomerCalculate = new SearchCustomerCalculate(customerBase);

    @Test
    public void searchByNameTest() {
        Customer customer1 = new Customer(0, "vasya petrov", LocalDate.of(1990, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), true);
        customerBase.add(customer1);
        for (Customer customer : searchCustomerCalculate.searchByName("petrov").getCustomerSet()) {
            Assert.assertEquals(customer, customer1);
        }
    }

    @Test
    public void searchByCar() {
        Customer customer1 = new Customer(0, "vasya", LocalDate.of(1990, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"Opel"}), true);
        Customer customer2 = new Customer(1, "petya", LocalDate.of(1990, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"Citroen"}), true);
        customerBase.add(customer1);
        customerBase.add(customer2);
        for (Customer customer : searchCustomerCalculate.searchByCar("france").getCustomerSet()) {
            Assert.assertEquals(customer, customer2);
        }
    }
}

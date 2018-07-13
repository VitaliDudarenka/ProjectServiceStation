package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class InfoCalculateTest {
    private CustomerBase customerBase = new CustomerBase();
    private InfoCalculate infoCalculate = new InfoCalculate(customerBase);

    @Test
    public void currentBirthdayTest() {
        Customer customer1 = new Customer(0, "vasya", LocalDate.of(1990, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), true);
        customerBase.add(customer1);
        for (Customer customer : infoCalculate.currentBirthdayList().getCustomerSet()) {
            Assert.assertEquals(customer, customer1);
        }
    }

    @Test
    public void lastOrderTest() {
        Customer customer1 = new Customer(0, "vasya", LocalDate.of(LocalDate.now().getYear()-1, 05, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), true);
        Customer customer2 = new Customer(0, "petya", LocalDate.now(), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), true);
        customerBase.add(customer1);
        customerBase.add(customer2);
        for (Customer customer : infoCalculate.notAppealList().getCustomerSet()) {
            System.out.println(customer.toString());
            Assert.assertEquals(customer, customer1);
        }
    }

    @Test
    public void discountPercentTest() {
        Customer customer1 = new Customer(0, "vasya", LocalDate.of(LocalDate.now().getYear() - 1, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), true);
        Customer customer2 = new Customer(1, "petya", LocalDate.of(LocalDate.now().getYear() - 1, 12, 12), LocalDate.of(1990, LocalDate.now().getMonth(), 22), Arrays.asList(new String[]{"opel"}), false);
        customerBase.add(customer1);
        customerBase.add(customer2);
        Assert.assertTrue(infoCalculate.percentOfDiscount() == 50);
    }

}

package by.itacademy.serviceStation.service.comparators;

import by.itacademy.serviceStation.domain.Customer;

import java.util.Comparator;

public class OrderDateComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        long date1 = o1.getLastOrder().toEpochDay();
        long date2 = o2.getLastOrder().toEpochDay();
        return (int) (date1 - date2);
    }
}

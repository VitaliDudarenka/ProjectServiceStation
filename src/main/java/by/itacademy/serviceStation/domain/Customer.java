package by.itacademy.serviceStation.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private LocalDate lastOrder;
    private LocalDate dateOfBirth;
    private List<String> car;
    private boolean discount;

    public Customer(int id, String name, LocalDate lastOrder, LocalDate dateOfBirth, List<String> car, boolean discount) {
        this.id = id;
        this.name = name;
        this.lastOrder = lastOrder;
        this.dateOfBirth = dateOfBirth;
        this.car = car;
        this.discount = discount;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(LocalDate lastOrder, DateTimeFormatter formatter) {
        this.lastOrder = lastOrder;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth, DateTimeFormatter formatter) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getCar() {
        return car;
    }

    public void setCar(List<String> car) {
        this.car = car;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastOrder=" + lastOrder +
                ", dateOfBirth=" + dateOfBirth +
                ", car=" + car +
                ", discount=" + discount +
                '}' + "\n";
    }
}

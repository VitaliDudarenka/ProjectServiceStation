package by.itacademy.serviceStation;


import by.itacademy.serviceStation.domain.CustomerBase;
import by.itacademy.serviceStation.domain.OrderTable;
import by.itacademy.serviceStation.service.InfoCalculate;
import by.itacademy.serviceStation.service.InfoOutput;
import by.itacademy.serviceStation.service.Menu;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        CustomerBase customerBase = new CustomerBase();
        OrderTable orderTable = new OrderTable(customerBase);
        orderTable.uploadCustomers();
        InfoCalculate infoCalculate = new InfoCalculate(customerBase);
        InfoOutput infoOutput = new InfoOutput(customerBase, infoCalculate);
        Menu menu = new Menu(customerBase, infoOutput);
        menu.exec();
    }
}

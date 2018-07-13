package by.itacademy.serviceStation.domain;

import by.itacademy.serviceStation.parsers.json.JSONCustomerUploader;
import by.itacademy.serviceStation.parsers.xml.XMLCustomerUploader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class OrderTable {
    private CustomerBase customerBase;
    private JSONCustomerUploader jsonCustomerUploader = new JSONCustomerUploader("http://kiparo.ru/t/service_station.json");
    private XMLCustomerUploader xmlCustomerUploader = new XMLCustomerUploader("http://kiparo.ru/t/service_station.xml");

    public OrderTable(CustomerBase customerBase) {
        this.customerBase = customerBase;
    }

    public void uploadCustomers() throws IOException {
        try {
            customerBase.addAll(jsonCustomerUploader.execute().getCustomerSet());
            customerBase.addAll(xmlCustomerUploader.execute().getCustomerSet());
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}

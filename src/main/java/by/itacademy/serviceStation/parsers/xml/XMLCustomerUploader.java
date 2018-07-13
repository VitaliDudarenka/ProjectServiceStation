package by.itacademy.serviceStation.parsers.xml;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLCustomerUploader {
    private String urlAdress;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public XMLCustomerUploader(String urlAdress) {
        this.urlAdress = urlAdress;
    }

    public CustomerBase execute() throws IOException, ParserConfigurationException, SAXException {
        CustomerBase customerBase = new CustomerBase();
        URL url = new URL(urlAdress);
        URLConnection urlCon = url.openConnection();
        InputStream inputStream = urlCon.getInputStream();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        Node root = doc.getDocumentElement();
        doc.getDocumentElement().normalize();
        NodeList pats = root.getChildNodes();
        NodeList nList = doc.getElementsByTagName("customers");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Customer customer = new Customer();
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                customer.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                customer.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                customer.setLastOrder(LocalDate.parse(eElement.getElementsByTagName("lastOrder").item(0).getTextContent()), formatter);
                customer.setCar(carsSet(eElement));
                customer.setDiscount(eElement.getElementsByTagName("discount").item(0).getTextContent().equals("true"));
            }
            customerBase.add(customer);
        }
        return customerBase;
    }

    private List<String> carsSet(Element element) {
        List<String> cars = new ArrayList<>();
        for (int i = 0; i < element.getElementsByTagName("car").getLength(); i++) {
            cars.add(element.getElementsByTagName("car").item(i).getTextContent());
        }
        return cars;
    }
}

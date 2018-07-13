package by.itacademy.serviceStation.parsers.json;

import by.itacademy.serviceStation.domain.Customer;
import by.itacademy.serviceStation.domain.CustomerBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JSONCustomerUploader {
    private String urlAdress;

    public JSONCustomerUploader(String urlAdress) {
        this.urlAdress = urlAdress;
    }

    public CustomerBase execute() throws IOException {
        URL url = new URL(urlAdress);
        URLConnection urlCon = url.openConnection();
        InputStream inputStream = urlCon.getInputStream();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(Boolean.class, new BooleanDeserializer())
                .registerTypeAdapter(ArrayList.class, new CarListDeserializer())
                .create();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        CustomerBase json = gson.fromJson(bufferedReader,CustomerBase.class);
        return json;
    }
}

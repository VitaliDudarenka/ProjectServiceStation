package by.itacademy.serviceStation.domain;

import java.util.*;

public class Cars {
    private static final Map<String, String> carsByRegions = new HashMap<>();

    public void initializeList() {
        carsByRegions.put("Lada", "Russia");
        carsByRegions.put("BMW 5", "Germany");
        carsByRegions.put("Opel", "Germany");
        carsByRegions.put("Audi", "Germany");
        carsByRegions.put("Citroen", "France");
        carsByRegions.put("Peugeot", "France");
        carsByRegions.put("Toyota", "Japan");
    }

    public List<String> search(String region) {
        List<String> cars = new ArrayList<>();
        Set<Map.Entry<String, String>> set = carsByRegions.entrySet();
        for (Map.Entry<String, String> me : set) {
            if (me.getValue().equalsIgnoreCase(region))
                cars.add(me.getKey());
        }
        return cars;
    }
}

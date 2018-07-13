package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.CustomerBase;

public interface Search {
    CustomerBase searchByName(String name);

    CustomerBase searchByCar(String region);
}

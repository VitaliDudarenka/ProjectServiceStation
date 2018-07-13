package by.itacademy.serviceStation.service;

import by.itacademy.serviceStation.domain.CustomerBase;

public interface Info {
    CustomerBase currentBirthdayList();

    CustomerBase notAppealList();

    double percentOfDiscount();
}

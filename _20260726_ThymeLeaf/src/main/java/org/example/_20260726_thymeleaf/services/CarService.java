package org.example._20260726_thymeleaf.services;

import org.example._20260726_thymeleaf.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class CarService {
    public List<Car> cars = new ArrayList<>();

    private void fillCarTestData() {
        cars.add(
                new Car("Volkswagen", 200, "red", true));
        cars.add(
                new Car("Tesla", 130, "white", false));
        cars.add(
                new Car("BMW", 210, "yellow", true));
    }

    public CarService() {
//        fillCarTestData();
    }
}

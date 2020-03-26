package com.example.speedway.Speedway.Trials.API.controllers;

import com.example.speedway.Speedway.Trials.API.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    public CarService() {

    }
    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }


    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }


    public Car createCar(Car car) {

        return carRepository.save(car);

    }

}



package com.example.speedway.Speedway.Trials.API.controllers;

import com.example.speedway.Speedway.Trials.API.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }


    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }


    Car createCar(Car car) {

        return carRepository.save(car);

    }


//    public void save(Car car) {
//    }

}



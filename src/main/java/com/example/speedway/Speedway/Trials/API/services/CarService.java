package com.example.speedway.Speedway.Trials.API.services;

import com.example.speedway.Speedway.Trials.API.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public CarService() {}

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }


    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }


    public Car createCar(Car car) {

        return carRepository.save(car);

    }

    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        // if car is NOT FOUND
        if (!car.isPresent()) {
            throw new RuntimeException("Cannot find car with id " + id);
        }
        // we use getter method since its an optional
        return car.get();
    }

}







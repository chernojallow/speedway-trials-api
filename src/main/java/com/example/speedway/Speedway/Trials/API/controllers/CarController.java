package com.example.speedway.Speedway.Trials.API.controllers;


import com.example.speedway.Speedway.Trials.API.entities.Car;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import com.example.speedway.Speedway.Trials.API.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    final CarService carService;

    CarRepository carRepository;

    @Autowired
    public CarController (CarService carService){
        this.carService = carService;
    }

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody Car car) {

        return ResponseEntity.ok(carService.createCar(car));
    }


    @GetMapping
    ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getOrderById(@PathVariable Long id){
        Car car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
        Car car = carService.getCarById(id);

        return ResponseEntity.ok(car);


        }






    }




package com.example.speedway.Speedway.Trials.API;


import com.example.speedway.Speedway.Trials.API.controllers.CarService;
import com.example.speedway.Speedway.Trials.API.entities.Car;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CarServiceTest {

    @Autowired
    CarRepository carRepository;

    CarService carController;

    @BeforeEach
    void setUp(){
        carController = new CarService(carRepository);

    }
    @Test
    void getAllCars(){
        Car car = new Car( "myHonda", "nissan" , "2019", "Cherno","PENDING", 80);
        System.out.println(car);
        carController.save(car);

        int expected = 1;
        // Exercise
        int actual = carController.getAllCars().size();

        // Assert
        assertEquals(expected, actual);
        // Teardown


    }

}

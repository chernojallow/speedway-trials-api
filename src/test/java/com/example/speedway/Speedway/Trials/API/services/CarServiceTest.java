package com.example.speedway.Speedway.Trials.API.services;


import com.example.speedway.Speedway.Trials.API.services.CarService;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
public class CarServiceTest {

    @Autowired
    CarRepository carRepository;

    CarService carController;

    @BeforeEach
    void setUp(){
        carController = new CarService(carRepository);

    }

}

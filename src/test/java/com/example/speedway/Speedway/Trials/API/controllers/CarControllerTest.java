package com.example.speedway.Speedway.Trials.API.controllers;

import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import com.example.speedway.Speedway.Trials.API.services.CarService;
import com.example.speedway.Speedway.Trials.API.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;


//    @MockBean
//    CarRepository carRepository;


    ObjectMapper mapper = new ObjectMapper();
    final String baseUrl = "/api/cars";
    @Test
    void createCar() throws Exception {
        Car car = new Car("car", "car", "car", "car", "car", 100);
        String newCarJson = mapper.writeValueAsString(car);
        when(carService.createCar(ArgumentMatchers.any(Car.class))).thenReturn(car);

        mockMvc.perform(post(baseUrl).content(newCarJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(car.getId()))
                .andExpect(jsonPath("$.nickname").value(car.getNickname()));
    }


    @Test
    void getAllCars() throws Exception{

        //Setup
        ArrayList<Car> cars = new ArrayList<>();
        Car car = new Car();
        cars.add(car);
        when(carService.getAllCars()).thenReturn(cars);
        //Exercise
        mockMvc.perform(get(baseUrl).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(cars.size())));

    }

    @Test
    void getCarsById() throws Exception {
        // Create Car with ID
        Car car = new Car("car", "car", "car", "car", "car", 100);
        car.setId(1L);
        String newCarJson = mapper.writeValueAsString(car);
        // Mockito Mock Return
        when(carService.getCarById(car.getId())).thenReturn(car);
        // Appropriate Rest URL
        String idUrl = baseUrl + "/" + car.getId();
        // Mock Controller to Service Call
        mockMvc.perform(get(idUrl).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

}

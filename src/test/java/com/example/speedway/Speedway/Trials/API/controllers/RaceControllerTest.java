package com.example.speedway.Speedway.Trials.API.controllers;


import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.repository.CarRepository;
import com.example.speedway.Speedway.Trials.API.services.CarService;
import com.example.speedway.Speedway.Trials.API.entities.Car;
import com.example.speedway.Speedway.Trials.API.services.RaceService;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RaceControllerTest {

    @Autowired
    MockMvc mockMVc;

    @MockBean
    RaceService raceService;

    ObjectMapper mapper = new ObjectMapper();
    final String baseUrl = "/api/races";


    @Test
    void createRaceTest() throws Exception {

      //parse string to LocalDate
        String time1 = "2019-03-27";
        LocalDate date = LocalDate.parse(time1);


       //parse string to LocalTime
        String string = "10:10";
        LocalTime time= LocalTime.parse(string);


        Race race = new Race("nissan", "stock_car", date,time,"cherno","lamin");
        System.out.println(race);
        String newRaceJson = mapper.writeValueAsString(race);
        when(raceService.createRace(ArgumentMatchers.any(Race.class))).thenReturn(race);

        mockMVc.perform(post(baseUrl).content(newRaceJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(race.getId()))
            .andExpect(jsonPath("$.name").value(race.getName()));


    }


}

package com.example.speedway.Speedway.Trials.API.controllers;


import com.example.speedway.Speedway.Trials.API.entities.Race;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

        Race race = new Race("nissan", "stock_car", "10-05-2020","10:10","cherno","lamin");
        System.out.println(race);
        String newRaceJson = mapper.writeValueAsString(race);
        when(raceService.createRace(ArgumentMatchers.any(Race.class))).thenReturn(race);

        mockMVc.perform(post(baseUrl).content(newRaceJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(race.getId()))
            .andExpect(jsonPath("$.name").value(race.getName()));

    }

    @Test
    void getAllRace() throws Exception {
        ArrayList<Race> races = new ArrayList<>();

      final String baseUrl = "/api/races";
      when(raceService.getAllRace()).thenReturn(new ArrayList<>());
      mockMVc.perform(get(baseUrl).accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$",hasSize(races.size())));

    }

    @Test
    void getRaceById() throws Exception {

        //Setup
        Race race = new Race();
        race.setId(1L);

        //Exercise
        String json = mapper.writeValueAsString(race);
        when(raceService.getRaceById(race.getId())).thenReturn(race);

        //Assert
        String idUrl = baseUrl + "/" +race.getId();
        mockMVc.perform(get(idUrl).accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());

    }

    @Test
    void updateRace() throws Exception {
        // Setup
        Race expectedRace = new Race();
              expectedRace.setId(1L);
              String json = mapper.writeValueAsString(expectedRace);
              //Exercise
        when(raceService.updateRace(anyLong(), any(Race.class))).thenReturn(expectedRace);

        //Assert
        mockMVc.perform(put(baseUrl + "/update/2" ).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expectedRace.getId()));

     }

    @Test
    void deleteRaceById() throws Exception {
        //Setup
        when(raceService.deleteById(ArgumentMatchers.any(Long.class))).thenReturn(true);

        //Exercise
        mockMVc.perform(get(baseUrl+ "/delete//1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
     }

}

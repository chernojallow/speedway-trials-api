package com.example.speedway.Speedway.Trials.API;


import com.example.speedway.Speedway.Trials.API.controllers.CarController;
import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarController carController;


    @Test
    void getAllCars() throws Exception{

    //Setup
    int expected = 0;
    when(carController.getAllCars()).thenReturn(new ArrayList<>());

    //Exercise
    mockMvc.perform(get("/api/cars").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(expected)));

}



}

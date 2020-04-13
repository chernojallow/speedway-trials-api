package com.example.speedway.Speedway.Trials.API.services;

import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.repository.RaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
public class RaceServiceTest {

    @Autowired
    RaceRepository raceRepository;

    RaceService raceService;

    @BeforeEach
     void setUp(){
        raceService = new RaceService(raceRepository);
    }

    @Test
    void createRace() {
        // Setup
        Race race = new Race();
        race.setDate("2020-10-10");
        race.setName("Sam");

        // Exercise
        Race savedMovie = raceService.createRace(race);
        // Assert
        assertNotNull(savedMovie.getId());

        // Teardown
        raceRepository.deleteAll();
    }

    @Test
    void getAllRace(){

        //Setup
        List<Race> race = new ArrayList<>();
        List<Race> races = raceService.getAllRace();

        //Exercise
        assertEquals(race.size(), races.size());
        assertTrue(race.containsAll(races));

    }

}

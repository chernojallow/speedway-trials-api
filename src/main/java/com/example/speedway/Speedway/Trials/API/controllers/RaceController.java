package com.example.speedway.Speedway.Trials.API.controllers;

import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.services.RaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    final RaceService raceService;

    public RaceController( RaceService raceService){
        this.raceService = raceService;
    }

    @PostMapping
    ResponseEntity<Race> createRace(@RequestBody Race race){
        return ResponseEntity.ok(raceService.createRace(race));
    }

    @RequestMapping
    ResponseEntity <List<Race>> getAllRace(){
        return ResponseEntity.ok(raceService.getAllRace());
    }

}

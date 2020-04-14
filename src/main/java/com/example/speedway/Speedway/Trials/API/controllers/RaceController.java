package com.example.speedway.Speedway.Trials.API.controllers;

import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.services.RaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    ResponseEntity <List<Race>> getAllRace(){
        return ResponseEntity.ok(raceService.getAllRace());
    }


    @GetMapping("/{id}")
    ResponseEntity<Race> getRaceById(Long id){
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

    @PutMapping("/update/{updateId}")
    ResponseEntity<Race> updateRace(@PathVariable Long updateId, @RequestBody Race race){

        return ResponseEntity.ok(raceService.updateRace(updateId, race));
    }

    @GetMapping("/delete/{id}")
    ResponseEntity<Object> deleteRaceById( @PathVariable Long id){

        boolean success = raceService.deleteById(id);
        if(success){
            return ResponseEntity.ok(null);
        }else{
            return ResponseEntity.badRequest().body("Race with id" + id + "was not found");
        }
    }


}

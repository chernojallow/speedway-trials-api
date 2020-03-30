package com.example.speedway.Speedway.Trials.API.services;

import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;


    public RaceService(){}

    public RaceService( RaceRepository raceRepository){
        this.raceRepository = raceRepository;
    }


    public Race createRace(Race race){
        return raceRepository.save(race);
    }

    public List<Race> getAllRace() {
        return this.raceRepository.findAll();
    }
}

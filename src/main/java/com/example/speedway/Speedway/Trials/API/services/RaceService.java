package com.example.speedway.Speedway.Trials.API.services;

import com.example.speedway.Speedway.Trials.API.entities.Race;
import com.example.speedway.Speedway.Trials.API.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {


    RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Race createRace(Race race) {

        return raceRepository.save(race);
    }

    public List<Race> getAllRace() {
        return this.raceRepository.findAll();
    }

    public Race getRaceById(Long id) {

        Optional<Race> race = raceRepository.findById(id);
        if (!race.isPresent()) {
            throw new RuntimeException("Race is not found");
        } else {
            return race.get();
        }

    }

    public Race updateRace(long raceId, Race race) {

            Race newRace = updateRace(raceId, race);
            newRace.update(newRace);
            return createRace(race);
        }

    public boolean deleteById(Long id) {
        try {
            raceRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
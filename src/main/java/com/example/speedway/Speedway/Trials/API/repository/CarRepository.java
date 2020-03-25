package com.example.speedway.Speedway.Trials.API.repository;

import com.example.speedway.Speedway.Trials.API.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {



}

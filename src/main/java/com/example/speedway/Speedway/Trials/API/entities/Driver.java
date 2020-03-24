package com.example.speedway.Speedway.Trials.API.entities;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class Driver {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private Integer age;
    private LocalDate birthDate;
    private Car car;
    private Integer wins;
    private Integer losses;
//    private RaceRecord raceRecord;
//    private Sponsor sponsor;
    public Driver(){}
    // New Driver
    public Driver(String firstName, String lastName, String nickName, Integer age, LocalDate birthDate, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.car = car;
        this.wins = 0;
        this.losses = 0;
    }
    // Adding in Driver Information Manually
    public Driver(String firstName, String lastName, String nickName, Integer age, LocalDate birthDate, Car car, Integer wins, Integer losses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.car = car;
        this.wins = wins;
        this.losses = losses;
    }
    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", car=" + car +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}

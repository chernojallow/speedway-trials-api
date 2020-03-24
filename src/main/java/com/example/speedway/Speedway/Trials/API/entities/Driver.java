package com.example.speedway.Speedway.Trials.API.entities;

import java.time.LocalDate;

public class Driver {
    public Long id;
    public String firstName;
    public String lastName;
    public String nickName;
    public Integer age;
    public LocalDate birthDate;
    public Car car;
    public Integer wins;
    public Integer losses;
    // Stretch Goals
    //   public RaceRecord raceRecord;
    //   public Sponsor sponsor;
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
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

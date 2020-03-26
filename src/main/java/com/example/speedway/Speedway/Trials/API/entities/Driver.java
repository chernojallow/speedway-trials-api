package com.example.speedway.Speedway.Trials.API.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="age")
    private int age;
    
    @Column(name="birthDate")
    private LocalDate birthDate;
    
    @Column(name="nickName")
    private String nickName;

    @Column(name="carId")
    private Car car;

    @Column(name="wins")
    private int wins;

    @Column(name="losses")
    private int losses;
    // Stretch Goals
    //   public RaceRecord raceRecord;
    //   public Sponsor sponsor;
    public Driver(){}
    // New Driver
    public Driver(String firstName, String lastName, String nickName, int age, LocalDate birthDate, Car car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.birthDate = birthDate;
        this.car = car;
        this.wins = 0;
        this.losses = 0;
    }
    // Adding in Driver Information Manually
    public Driver(String firstName, String lastName, String nickName, int age, LocalDate birthDate, Car car, int wins, int losses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

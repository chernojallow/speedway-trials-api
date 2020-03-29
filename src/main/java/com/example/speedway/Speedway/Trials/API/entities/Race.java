package com.example.speedway.Speedway.Trials.API.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Race {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @NotBlank(message="category is required.")
    private String category;
    @NotBlank(message="category is required.")
    private LocalDate date;
    @NotBlank(message="bestTime is required.")
    private LocalTime bestTime;
    @NotBlank(message="winner is required.")
    private String winner;
    @NotBlank(message="participants is required.")
    private String participants;


    public Race(){};

    public Race(Long id, String name, String category, LocalDate date,
                LocalTime bestTime, String winner, String participants) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winner = winner;
        this.participants = participants;
    }


    public Race(String name, String category, LocalDate date,
                LocalTime bestTime, String winner, String participants) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.bestTime = bestTime;
        this.winner = winner;
        this.participants = participants;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public void setBestTime(LocalTime   bestTime) {
        this.bestTime = bestTime;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", bestTime=" + bestTime +
                ", winner='" + winner + '\'' +
                ", participants='" + participants + '\'' +
                '}';
    }
}

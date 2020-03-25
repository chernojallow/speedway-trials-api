package com.example.speedway.Speedway.Trials.API.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Race {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @NotBlank(message="category is required.")
    private String category;
    @NotBlank(message="localDateTime is required.")
    private LocalDateTime date;
    @NotBlank(message="bestTime is required.")
    private LocalDateTime bestTime;
    @NotBlank(message="winner is required.")
    private String winner;
    @NotBlank(message="participants is required.")
    private String participants;



    public Race(Long id, String name, String category, LocalDateTime date,
                LocalDateTime bestTime, String winner, String participants) {

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getBestTime() {
        return bestTime;
    }

    public void setBestTime(LocalDateTime bestTime) {
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

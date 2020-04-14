package com.example.speedway.Speedway.Trials.API.entities;

import javax.persistence.*;

@Entity
public class Race {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column
    private String category;
    @Column
    private String date;
    @Column
    private String best_time;
    @Column
    private String winner;
    @Column
    private String participants;


    public Race(){};

    public Race(Long id, String name, String category, String date,
                String bestTime, String winner, String participants) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.best_time = bestTime;
        this.winner = winner;
        this.participants = participants;
    }


    public Race(String name, String category, String date,
                String bestTime, String winner, String participants) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.best_time = bestTime;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBest_time() {
        return best_time;
    }

    public void setBest_time(String  bestTime) {
        this.best_time = bestTime;
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
                ", bestTime=" + best_time +
                ", winner='" + winner + '\'' +
                ", participants='" + participants + '\'' +
                '}';
    }


    public void update(Race newRace) {
        if(newRace.getId()!=0)this.setId(newRace.getId());
        if(newRace.getName()!=null)this.setName(newRace.getName());
        if(newRace.getCategory()!=null)this.setCategory(newRace.getCategory());
        if(newRace.getDate()!=null)this.setDate(newRace.getDate());
        if(newRace.getBest_time()!=null)this.setBest_time(newRace.getBest_time());
        if(newRace.getWinner()!=null)this.setWinner(newRace.getWinner());
        if(newRace.getParticipants()!=null)this.setParticipants(newRace.getParticipants());

    }
}

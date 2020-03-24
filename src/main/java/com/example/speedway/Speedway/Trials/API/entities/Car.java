package com.example.speedway.Speedway.Trials.API.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nickname")
    private String nickname;
    @NotBlank(message="model is required.")
    private String model;
    @NotBlank(message="year is required.")
    private LocalDateTime year;
    @NotBlank(message="driver is required.")
    private String driver;
    @NotBlank(message="status is required.")
    private String status;
    @NotBlank(message="top_speed is required.")
    private String email;
    private int top_speed;


    public Car(Long id, String nickname, String model, LocalDateTime year, String driver, String status, int top_speed) {
        this.id = id;
        this.nickname = nickname;
        this.model = model;
        this.year = year;
        this.driver = driver;
        this.status = status;
        this.top_speed = top_speed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(int top_speed) {
        this.top_speed = top_speed;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", driver='" + driver + '\'' +
                ", status='" + status + '\'' +
                ", top_speed=" + top_speed +
                '}';
    }
}

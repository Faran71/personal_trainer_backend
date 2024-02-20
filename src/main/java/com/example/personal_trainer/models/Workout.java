package com.example.personal_trainer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "workout_date")
    private LocalDate workoutDate;

    @Column(name = "workout_time")
    private LocalTime workoutTime;

    @Column
    private String activity;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"workouts"})
    private User user;

    public Workout() {

    }

    public Workout(LocalDate workoutDate, LocalTime workoutTime, String activity, String description, User user) {
        this.workoutDate = workoutDate;
        this.workoutTime = workoutTime;
        this.activity = activity;
        this.description = description;
        this.user = user;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }

    public LocalTime getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(LocalTime workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

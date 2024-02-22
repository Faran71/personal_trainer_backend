package com.example.personal_trainer.models;

public class WorkoutDTO {

    private String activity;

    private Integer duration;

    private String description;

    public WorkoutDTO(String activity, Integer duration, String description) {
        this.activity = activity;
        this.duration = duration;
        this.description = description;
    }

    public WorkoutDTO(){}

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.personal_trainer.models;

public class UserDTO {

    private String name;

    private String email;

    private String password;

    private Integer weight;

    private String ageGroup;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password, Integer weight, String ageGroup){
        this.name = name;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.ageGroup = ageGroup;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

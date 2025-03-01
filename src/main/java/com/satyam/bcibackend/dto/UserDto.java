package com.satyam.bcibackend.dto;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.time.LocalDate;

@Document
public class UserDto {
    @MongoId
    private String id;
    private String name;
    private int age;
    private String gender;
    private int brainAge;
    private int score;
    private List<UserSessionDto> sessions;
    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserDto(String id, String name, int age, String gender, int brainAge, int score, List<UserSessionDto> sessions, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.brainAge = brainAge;
        this.score = score;
        this.sessions = sessions;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBrainAge() {
        return brainAge;
    }

    public void setBrainAge(int brainAge) {
        this.brainAge = brainAge;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<UserSessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<UserSessionDto> sessions) {
        this.sessions = sessions;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


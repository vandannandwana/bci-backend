package com.satyam.bcibackend.dto;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.time.LocalDate;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private int brainAge;
    private List<RecordDto> records;
    private boolean isPremiumUser;
    private LocalDate premiumExpireDate;
    private int score;
    private List<LikeDto> likes;
    private List<MostOpenedDto> mostOpened;
    private List<SessionDto> sessions;
    private String phoneNumber;


    public UserDto() {
    }

    public UserDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserDto(String name, int age, String gender, int brainAge, int score, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.brainAge = brainAge;
        this.score = score;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public List<RecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<RecordDto> records) {
        this.records = records;
    }

    public boolean isPremiumUser() {
        return isPremiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        isPremiumUser = premiumUser;
    }

    public LocalDate getPremiumExpireDate() {
        return premiumExpireDate;
    }

    public void setPremiumExpireDate(LocalDate premiumExpireDate) {
        this.premiumExpireDate = premiumExpireDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<LikeDto> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDto> likes) {
        this.likes = likes;
    }

    public List<MostOpenedDto> getMostOpened() {
        return mostOpened;
    }

    public void setMostOpened(List<MostOpenedDto> mostOpened) {
        this.mostOpened = mostOpened;
    }

    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }
}


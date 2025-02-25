package com.satyam.bcibackend.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SessionDto {
    @Id
    String id;
    String sessionName;
    Long sessionTime;
    Long averageTime;
    Long lowestTime;
    Long highestTime;
    Long averageConcentration;

    public Long getAverageConcentration() {
        return averageConcentration;
    }

    public void setAverageConcentration(Long averageConcentration) {
        this.averageConcentration = averageConcentration;
    }

    public SessionDto() {}

    public SessionDto(String id, String sessionName, Long sessionTime, Long averageTime, Long lowestTime, Long highestTime,Long averageConcentration) {
        this.id = id;
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
        this.averageTime = averageTime;
        this.lowestTime = lowestTime;
        this.highestTime = highestTime;
        this.averageConcentration = averageConcentration;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Long getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Long sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Long getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Long averageTime) {
        this.averageTime = averageTime;
    }

    public Long getLowestTime() {
        return lowestTime;
    }

    public void setLowestTime(Long lowestTime) {
        this.lowestTime = lowestTime;
    }

    public Long getHighestTime() {
        return highestTime;
    }

    public void setHighestTime(Long highestTime) {
        this.highestTime = highestTime;
    }
}

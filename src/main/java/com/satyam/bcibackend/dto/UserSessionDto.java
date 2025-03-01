package com.satyam.bcibackend.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class UserSessionDto {

    /*user id ,
     session id,
     selected duration,
     actual duration,
     selected threshold,
     list of meditation/focus values (per second),
     list of values above threshold,
     count of values above threshold
     and remaining data as per your choice*/

    @MongoId
    private String sessionId;
    private String sessionName;
    private String userId;
    private Long actualDuration;
    private Long listenDuration;
    private Integer selectedThreshold;
    private List<Integer> focusValues;
    private List<Integer> overThresholdValues;
    private Long overThresholdCount;


    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Long actualDuration) {
        this.actualDuration = actualDuration;
    }

    public Long getListenDuration() {
        return listenDuration;
    }

    public void setListenDuration(Long listenDuration) {
        this.listenDuration = listenDuration;
    }

    public Integer getSelectedThreshold() {
        return selectedThreshold;
    }

    public void setSelectedThreshold(Integer selectedThreshold) {
        this.selectedThreshold = selectedThreshold;
    }

    public List<Integer> getFocusValues() {
        return focusValues;
    }

    public void setFocusValues(List<Integer> focusValues) {
        this.focusValues = focusValues;
    }

    public List<Integer> getOverThresholdValues() {
        return overThresholdValues;
    }

    public void setOverThresholdValues(List<Integer> overThresholdValues) {
        this.overThresholdValues = overThresholdValues;
    }

    public Long getOverThresholdCount() {
        return overThresholdCount;
    }

    public void setOverThresholdCount(Long overThresholdCount) {
        this.overThresholdCount = overThresholdCount;
    }

}

package com.satyam.bcibackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSessionRequestDto {
    private String userId;
    private String sessionId;
    private String sessionName;
    private Long actualDuration;
    private Long listenDuration;
    private Integer selectedThreshold;
    private List<Integer> focusValues;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
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
}

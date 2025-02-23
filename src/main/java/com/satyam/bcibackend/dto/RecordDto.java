package com.satyam.bcibackend.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RecordDto {
    private String sessionId;
    private Date fullDate;
    public ArrayList<Integer> values;// Value of brain waves

    public RecordDto(String sessionId, Date date) {
        this.sessionId = sessionId;
        this.fullDate = date;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getFullDate() {
        return fullDate;
    }

    public void setFullDate(Date fullDate) {
        this.fullDate = fullDate;
    }

    public ArrayList<Integer> getValue() {
        return values;
    }

    public void setValue(ArrayList<Integer> values) {
        this.values = values;
    }
}

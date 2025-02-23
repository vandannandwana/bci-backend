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

    public RecordDto(String sessionId, Date fullDate, ArrayList<Integer> values) {
        this.sessionId = sessionId;
        this.fullDate = fullDate;
        this.values = values;
    }
    public RecordDto() {
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

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
}

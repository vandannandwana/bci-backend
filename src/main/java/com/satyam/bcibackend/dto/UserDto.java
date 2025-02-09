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
    private List<SessionTimeDto> eachSessionTime;

}


package com.satyam.bcibackend.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MostOpenedDto {
    private String id;
    private String sessionId;
    private int timesOpened;
}


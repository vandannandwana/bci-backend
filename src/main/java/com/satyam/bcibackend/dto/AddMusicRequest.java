package com.satyam.bcibackend.dto;

import lombok.Data;

@Data
public class AddMusicRequest {
    private String title;
    private String artist;
    private String album;
    private String filePath;
}

package com.satyam.bcibackend.dto;

import com.satyam.bcibackend.userentity.Song;
import lombok.Data;

@Data
public class MusicResponse {
    public MusicResponse(Song song){
        this.title= song.getTitle();
        this.album= song.getAlbum();
        this.artist = song.getArtist();
        this.filePath= song.getFilePath();
    }
    private String title;
    private String artist;
    private String album;
    private String filePath;



}

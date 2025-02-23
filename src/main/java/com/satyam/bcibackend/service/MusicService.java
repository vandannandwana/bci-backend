package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.AddMusicRequest;
import com.satyam.bcibackend.dto.MusicResponse;
import com.satyam.bcibackend.repositories.SongRepository;
import com.satyam.bcibackend.userentity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MusicService {

    @Autowired
    private SongRepository songRepository;

    public void addMusic(AddMusicRequest addMusicRequest) {
        Song song = new Song();
        song.setAlbum(addMusicRequest.getAlbum());
        song.setArtist(addMusicRequest.getArtist());
        song.setTitle(addMusicRequest.getTitle());
        song.setFilePath(addMusicRequest.getFilePath());
        songRepository.save(song);
    }

    public List<Song> searchMusic(String name) {
        List<Song> songs = songRepository.searchBySong(name);
        return songs;
    }

    public List<Song> getRecommendedSong() {
        List<Song> allSongs = songRepository.findAll();
        return allSongs;
    }
}

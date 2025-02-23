package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.AddMusicRequest;
import com.satyam.bcibackend.service.MusicService;
import com.satyam.bcibackend.userentity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicController {
//D:\Cerbo\bci-backend\bci-backend\src\main\resources\static\music1.mp3
    @Autowired
    MusicService musicService;


    @GetMapping(value = "/stream",produces = "audio/mpeg")
    public ResponseEntity<ResourceRegion> streamSong(@RequestHeader HttpHeaders headers, @RequestParam String name) throws IOException {
        String songName = name;

        Resource resource = new ClassPathResource("songs/"+name+".mp3");

        if(!resource.exists()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        long contentLength = resource.contentLength();

        long rangeStart = 0;
        long rangeEnd = Math.min(1024*1024,contentLength-1);

        if(!headers.getRange().isEmpty()){

            HttpRange range = headers.getRange().getFirst();
            rangeStart = range.getRangeStart(contentLength);
            rangeEnd = range.getRangeEnd(contentLength);
        }

        ResourceRegion region = new ResourceRegion(resource,rangeStart,rangeEnd - rangeStart +1);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(region);


    }


    @PostMapping("/add-music")
    public ResponseEntity<Void> addMusic(@RequestBody AddMusicRequest addMusicRequest) {
        musicService.addMusic(addMusicRequest);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<Song>> searchMusic(@RequestParam String name) {

        List<Song> response = musicService.searchMusic(name);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/recomended-song")
    public ResponseEntity<List<Song>> recommendedSong(){
        List<Song> musicList= musicService.getRecommendedSong();
        return ResponseEntity.ok(musicList);
    }


}

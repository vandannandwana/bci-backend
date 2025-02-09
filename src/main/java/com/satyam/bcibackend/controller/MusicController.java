package com.satyam.bcibackend.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/songs")
public class MusicController {
//D:\Cerbo\bci-backend\bci-backend\src\main\resources\static\music.mp3


    @GetMapping(value = "/stream",produces = "audio/mpeg")
    public ResponseEntity<ResourceRegion> streamSong(@RequestHeader HttpHeaders headers) throws IOException {
        String songName = "music.mp3";

        Resource resource = new ClassPathResource("songs/music.mp3");

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


}

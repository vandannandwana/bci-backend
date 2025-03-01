package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.SessionDto;
import com.satyam.bcibackend.service.SessionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @GetMapping("/getSessions")
    public ResponseEntity<List<SessionDto>> getAllSessions(){

        List<SessionDto>sessions = sessionService.getAllSessions();

        if(sessions != null){
            return ResponseEntity.ok(sessions);
        }else {
            return ResponseEntity.noContent().build();
        }


    }


    @GetMapping("getById/{id}")
    public ResponseEntity<SessionDto> getSessionById(@PathVariable("id") String id){

        SessionDto session = sessionService.getSessionById(id);

        if(session != null){
            return ResponseEntity.ok(session);
        }else {
            return ResponseEntity.noContent().build();
        }

    }



    @GetMapping("getByName/{name}")
    public ResponseEntity<List<SessionDto>> getSessionByName(@PathVariable("name") String name){

        List<SessionDto> sessions = sessionService.getSessionByName(name);

        if(sessions != null){
            return ResponseEntity.ok(sessions);
        }else {
            return ResponseEntity.noContent().build();
        }



    }


    @PostMapping("/addSession")
    public ResponseEntity<String> addSession(@RequestBody SessionDto session){

        if(sessionService.addSession(session)){
            return ResponseEntity.ok("Session Added Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Session not Added");
        }

    }

    @PostMapping("/addSessions")
    public ResponseEntity<String> addSessions(@RequestBody List<SessionDto> sessions){

        if(sessionService.addSessions(sessions)){
            return ResponseEntity.ok("Session Added Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Session not Added");
        }

    }











}
//    @GetMapping(value = "/stream",produces = "audio/mpeg")
//    public ResponseEntity<ResourceRegion> streamSong(@RequestHeader HttpHeaders headers, @RequestParam String name) throws IOException {
//        String songName = name;
//
//        Resource resource = new ClassPathResource("songs/"+name+".mp3");
//
//        if(!resource.exists()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        long contentLength = resource.contentLength();
//
//        long rangeStart = 0;
//        long rangeEnd = Math.min(1024*1024,contentLength-1);
//
//        if(!headers.getRange().isEmpty()){
//
//            HttpRange range = headers.getRange().getFirst();
//            rangeStart = range.getRangeStart(contentLength);
//            rangeEnd = range.getRangeEnd(contentLength);
//        }
//
//        ResourceRegion region = new ResourceRegion(resource,rangeStart,rangeEnd - rangeStart +1);
//
//        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
//                .contentType(MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM))
//                .body(region);
//
//
//    }

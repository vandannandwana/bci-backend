package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.SessionUpdateRequest;
import com.satyam.bcibackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @PostMapping("/update")
    public ResponseEntity<String> updateSession(@RequestBody SessionUpdateRequest request) {
        boolean updated = sessionService.updateSession(request);
        if (updated) {
            return ResponseEntity.ok("Session updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
    }
}


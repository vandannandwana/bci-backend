package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.SessionUpdateRequest;
import com.satyam.bcibackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final UserService userService;

    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateSession(@RequestBody SessionUpdateRequest request) {
        boolean updated = userService.updateSession(request);

        if (updated) {
            return ResponseEntity.ok("Session updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
    }
}


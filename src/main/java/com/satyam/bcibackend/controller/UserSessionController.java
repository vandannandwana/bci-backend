package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.UserSessionRequestDto;
import com.satyam.bcibackend.service.UserSessionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userSession")
public class UserSessionController {

    @Autowired
    UserSessionService userSessionService;

    @PostMapping("/addSession")
    public ResponseEntity<String> addUserSession(@RequestBody UserSessionRequestDto sessionRequestDto){

        if(userSessionService.addSession(sessionRequestDto)){
            return ResponseEntity.ok("Session Updated Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Session Not Updated Successfully");
        }

    }

}

package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.GenerateOtpRequest;
import com.satyam.bcibackend.dto.GenerateOtpResponse;
import com.satyam.bcibackend.dto.RegisterRequest;
import com.satyam.bcibackend.dto.RegisterResponse;
import com.satyam.bcibackend.service.AuthService;
import com.satyam.bcibackend.service.VonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/generate-otp")
    public ResponseEntity<Void> generateOtp(@RequestBody GenerateOtpRequest generateOtpRequest) {
        authService.generateOtp(generateOtpRequest.getPhoneNumber());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<RegisterResponse> verifyOtp(@RequestBody RegisterRequest registerRequest) throws IllegalAccessException {

        RegisterResponse response = new RegisterResponse();

        if(authService.verifyOtp(registerRequest)){
            response.setToken("Verification Successful");
        }else {
            response.setToken("Verification not Successful");
        }
        return ResponseEntity.ok(response);
    }
}

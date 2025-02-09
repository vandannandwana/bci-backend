package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.RegisterRequest;
import com.satyam.bcibackend.dto.RegisterResponse;

public interface AuthService {
    void generateOtp(String phoneNumber);
    RegisterResponse verifyOtp(RegisterRequest registerRequest) throws IllegalAccessException;
}

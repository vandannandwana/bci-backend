package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.RegisterRequest;

public interface AuthService {
    void generateOtp(String phoneNumber);
    boolean verifyOtp(RegisterRequest registerRequest) throws IllegalAccessException;
}

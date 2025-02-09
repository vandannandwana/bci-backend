package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.GenerateOtpResponse;
import com.satyam.bcibackend.dto.RegisterRequest;
import com.satyam.bcibackend.dto.RegisterResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {

    private final Map<String, String> phoneNumberDataBase = new HashMap<>();

    @Override
    public void generateOtp(String phoneNumber) {
        Random random = new Random();
        String otp = String.valueOf(random.nextInt(9000) + 1000);
        phoneNumberDataBase.put(phoneNumber, otp);
        System.out.println("OTP generated: " + otp + " for mobile " + phoneNumber);
        // Sent OTP to phoneNumber
        GenerateOtpResponse generateOtpResponse = new GenerateOtpResponse();
        generateOtpResponse.setMessage("Successfully sent the OTP to registered mobile number");
    }

    @Override
    public RegisterResponse verifyOtp(RegisterRequest registerRequest) throws IllegalAccessException {
        String phoneNumber = registerRequest.getPhoneNumber();
        String otp = registerRequest.getOtp();
        if (!phoneNumberDataBase.containsKey(phoneNumber)){
            throw new IllegalAccessException("Mobile Number is not registered");
        }
        String otpFromDB = phoneNumberDataBase.get(phoneNumber);
        if (!otp.equals(otpFromDB)) {
            throw new IllegalAccessException("OTP is invaid");
        }
        //Save the details in DB
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setToken("GENERATED TOKEN");
        return registerResponse;
    }
}

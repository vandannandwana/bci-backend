package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.GenerateOtpResponse;
import com.satyam.bcibackend.dto.RegisterRequest;
import com.satyam.bcibackend.dto.TemporaryUser;
import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.repositories.TemporaryUserRepository;
import com.satyam.bcibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    VonageService vonageService;

    @Autowired
    TemporaryUserRepository tempUserRepo;

    @Autowired
    UserRepository userRepository;

    @Override
    public void generateOtp(String phoneNumber) {
        Random random = new Random();
        String otp = String.valueOf(random.nextInt(9000) + 1000);

        TemporaryUser temp = tempUserRepo.findByPhoneNumber(phoneNumber);

        if(temp != null){
            temp.setOtp(otp);
            tempUserRepo.save(temp);
            return;
        }

        tempUserRepo.save(new TemporaryUser(phoneNumber,otp));
        System.out.println("OTP generated: " + otp + " for mobile " + phoneNumber);
        vonageService.sendMessage("Your OTP for CerboTech-BCI Application is : "+otp);
        // Sent OTP to phoneNumber
        GenerateOtpResponse generateOtpResponse = new GenerateOtpResponse();
        generateOtpResponse.setMessage("Successfully sent the OTP to registered mobile number");
    }

    @Override
    public boolean verifyOtp(RegisterRequest registerRequest){
        try {
            TemporaryUser temp = tempUserRepo.findByPhoneNumber(registerRequest.getPhoneNumber());
            if(temp != null){

                if(Objects.equals(temp.getOtp(), registerRequest.getOtp())){

                    userRepository.save(new UserDto(registerRequest.getPhoneNumber()));

                }

            }

            return true;
        }catch (Exception e){
            return false;
        }

    }
}

package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.RecordDto;
import com.satyam.bcibackend.dto.SessionUpdateRequest;
import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<UserDto> getAllUsers(){

        return userRepo.findAll();

    }

    public void addUser(UserDto user){
        try{
            userRepo.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void addUsers(List<UserDto> users){
        try{
            userRepo.saveAll(users);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public UserDto findUserByName(String name){
        try{
            return userRepo.findByNameRegex(name).getFirst();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new UserDto();
        }

    }

    public UserDto findUserById(String id){

        return userRepo.findById(id).get() != null ?userRepo.findById(id).get():null;
    }

    public boolean updateSession(SessionUpdateRequest request) {
        Optional<UserDto> optionalUser = userRepo.findById(request.getUserId());

        if (optionalUser.isPresent()) {
            UserDto user = optionalUser.get();
            List<RecordDto> records = user.getRecords();

            // If records list is null, initialize it
            if (records == null) {
                records = new ArrayList<>();
                user.setRecords(records);
            }

            // Find session
            RecordDto session = records.stream()
                    .filter(r -> r.getSessionId().equals(request.getSessionId()))
                    .findFirst()
                    .orElse(null);

            if (session != null) {
                // If session values list is null, initialize it
                if (session.getValues() == null) {
                    session.setValues(new ArrayList<>());
                }

                // Append new values
                session.getValues().addAll(request.getValues());
            } else {
                // Create new session
                RecordDto newRecord = new RecordDto();
                newRecord.setSessionId(request.getSessionId());
                newRecord.setFullDate(new java.util.Date());
                newRecord.setValues(new ArrayList<>(request.getValues())); // Ensure values list is initialized
                records.add(newRecord);
            }

            userRepo.save(user); // Save updated user
            return true;
        } else {
            return false;
        }
    }
}

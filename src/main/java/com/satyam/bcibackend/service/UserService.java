package com.satyam.bcibackend.service;
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

    public boolean addUser(UserDto user){
        try{
            UserDto temp = userRepo.findUserByPhoneNumber(user.getPhoneNumber());
            user.setId(temp.getId());
            userRepo.save(user);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
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

    public UserDto findUserByPhoneNumber(String phoneNumber){
        try{
            return userRepo.findUserByPhoneNumber(phoneNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new UserDto();
        }

    }

    public UserDto findUserById(String id){

        return userRepo.findById(id).get() != null ?userRepo.findById(id).get():null;
    }
}

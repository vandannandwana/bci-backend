package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}

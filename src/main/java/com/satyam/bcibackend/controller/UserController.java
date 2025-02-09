package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    ResponseEntity<String> addUser(@RequestBody UserDto user){

        try{
            userService.addUser(user);
            return ResponseEntity.ok("User Added Successfully");
        }catch (Exception e){
            return ResponseEntity.ok("Failed to pass your request with the error: "+e.getMessage());
        }

    }

    @GetMapping("/getUser/{name}")
    UserDto getUser(@PathVariable String name){

        try{
            return userService.findUserByName(name);
        }catch (Exception e){
            System.out.println("Failed to pass your request with the error: "+e.getMessage());
            return new UserDto();
        }

    }

    @PostMapping("/addUsers")
    ResponseEntity<String> addUsers(@RequestBody List<UserDto> users){

        try{
            userService.addUsers(users);
            return ResponseEntity.ok("User Added Successfully");
        }catch (Exception e){
            return ResponseEntity.ok("Failed to pass your request with the error: "+e.getMessage());
        }

    }

}

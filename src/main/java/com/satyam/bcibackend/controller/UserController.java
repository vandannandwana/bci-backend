package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.service.UserService;
import com.satyam.bcibackend.userentity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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


    @GetMapping("/getUserByNumber/{number}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable("number") String number) {
        try {
            UserDto user = userService.findUserByPhoneNumber(number);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build(); // User not found response
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            System.out.println("Failed to process your request with the error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Server error response
        }
    }



    @GetMapping("/getUserById/{id}")
    UserDto getUserById(@PathVariable String id){

        try{
            return userService.findUserById(id);
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

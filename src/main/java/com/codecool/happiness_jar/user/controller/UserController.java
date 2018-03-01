package com.codecool.happiness_jar.user.controller;


import com.codecool.happiness_jar.user.model.User;
import com.codecool.happiness_jar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{user_id}")
    public User getUser(@PathVariable("user_id") int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/delete/{user_id}")
    public String deleteUser(@PathVariable("user_id") int userId) {
            userService.deleteUserById(userId);
        return "User with Id: " + userId + "has been deleted!";
    }

    @PostMapping(value = "/registration-save")
    public ResponseEntity<Map<String, String>> registerUser(
                                       @RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("hashedpassword") String hashedPassword) {

        User registerUser = new User(name, email, hashedPassword);

        Map<String, String> responseMessage = new HashMap<>();
        ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity<>(responseMessage, HttpStatus.OK);

        try {
            for (User user : userService.getAllUsers()) {
                if(user.getEmail().equals(email)) {
                    responseMessage.put("error", "User already Registered!");
                    return responseEntity;
                }
            }
            userService.saveUser(registerUser);
            responseMessage.put("success", "Registration Success.");
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.put("error", "Registration Failed!");
        }
        return responseEntity;
    }

}

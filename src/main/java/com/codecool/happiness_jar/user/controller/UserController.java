package com.codecool.happiness_jar.user.controller;


import com.codecool.happiness_jar.user.model.User;
import com.codecool.happiness_jar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}

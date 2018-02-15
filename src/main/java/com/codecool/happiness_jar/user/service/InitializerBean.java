package com.codecool.happiness_jar.user.service;

import com.codecool.happiness_jar.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {
    public InitializerBean(UserService userService) {
        User user1 = new User("John", "john@gmail.com", "12345");
        userService.saveUser(user1);
        User user2 = new User("Tom", "tom@gmail.com", "67890");
        userService.saveUser(user2);
    }
}
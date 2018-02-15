package com.codecool.happiness_jar.user.service;

import com.codecool.happiness_jar.user.model.User;
import com.codecool.happiness_jar.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }
}

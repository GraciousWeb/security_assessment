package com.grace.security_assessment.controller;

import com.grace.security_assessment.model.User;
import com.grace.security_assessment.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public List<User> searchUser(@RequestParam String username) {
        // Vulnerable to SQL Injection
        return userRepository.findByUsernameUnsafe(username);
    }
}


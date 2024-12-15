package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service bean
public class AuthService {

    private final UserRepository userRepository;

    // Constructor with UserRepository
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
private PasswordEncoder passwordEncoder; // Use the interface


public User authenticateUser(String username, String password) {
    User user = userRepository.getUserByUsername(username);
    if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        return user;
    }
    return null;
}


    // public boolean registerUser(User user) {
    //     User existingUser = userRepository.getUserByUsername(user.getUsername());
    //     if (existingUser != null) {
    //         return false; // Username already exists
    //     }
    public boolean registerUser(User user) {
        try {
            User existingUser = userRepository.getUserByUsername(user.getUsername());
            if (existingUser != null) {
                return false; // Username already exists
            }
            userRepository.createUser(user);
            return true; // User registered successfully
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Registration failed
        }
    }
    
        // userRepository.createUser(user);
        // return true; // User registered successfully
    
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email); // Make sure this method exists in your UserRepository
    }
    @PostConstruct
public void init() {
    System.out.println("PasswordEncoder injected: " + (passwordEncoder != null));
}

    
}

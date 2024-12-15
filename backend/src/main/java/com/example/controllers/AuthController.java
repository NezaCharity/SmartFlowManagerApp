package com.example.controllers;

import com.example.models.User;
import com.example.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Login endpoint.
     * @param username User's username
     * @param password User's password
     * @return ResponseEntity with user details if login is successful
     */
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = authService.authenticateUser(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }

    /**
     * Register endpoint.
     * @param user User object
     * @return ResponseEntity with success message
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        authService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}

package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users.
     * @return List of users
     */
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Get a user by username.
     * @param username Username
     * @return User object
     */
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(null); // Not Found
        }
    }

    /**
     * Update user details.
     * @param user Updated user object
     * @return Success message
     */
    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }
}

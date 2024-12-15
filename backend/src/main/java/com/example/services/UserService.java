package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the database.
     * @return List of User objects
     */
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    /**
     * Retrieves a user by username.
     * @param username Username of the user
     * @return User object or null if not found
     */
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    /**
     * Updates a user's information.
     * @param user Updated User object
     */
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}

package com.VintageStore.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VintageStore.entity.User;
import com.VintageStore.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        // Add any validation or business logic here before saving
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        // Fetch the user from the database
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            // Update user details
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            // Update other fields as needed

            // Save the updated user
            return userRepository.save(user);
        }

        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

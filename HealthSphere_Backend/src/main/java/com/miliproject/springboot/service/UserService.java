package com.miliproject.springboot.service;

import com.miliproject.springboot.model.User;
import com.miliproject.springboot.repository.UserRepository;
import com.miliproject.springboot.model.User.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

/**
 * Service class for managing users in the system.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Get all users in the system.
     * @return List of User entities
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get a user by their ID.
     * @param id User ID
     * @return Optional User
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Get a user by email.
     * @param email user email
     * @return Optional User
     */
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Create a new user.
     * @param user User object to create
     * @return saved User
     */
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        if (userRepository.findByPhone(user.getPhone()).isPresent()) {
            throw new RuntimeException("Phone number already exists: " + user.getPhone());
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role if not set
        if (user.getRole() == null) {
            user.setRole(Role.PATIENT);
        }

        return userRepository.save(user);
    }

    /**
     * Update existing user.
     * @param id User ID to update
     * @param updatedUser User object containing updated info
     * @return updated User
     */
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            if (updatedUser.getRole() != null) {
                user.setRole(updatedUser.getRole());
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    /**
     * Delete a user by ID.
     * @param id User ID to delete
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}

package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepository handles all CRUD operations related to User entities.
 * This includes finding users by ID, email, or role.
 * 
 * It extends JpaRepository to leverage Spring Data JPA methods
 * and also allows us to define custom query methods.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by their email.
     * 
     * @param email The email of the user.
     * @return Optional<User> object which may or may not contain a user.
     */
    Optional<User> findByEmail(String email);

    /**
     * Find a user by their phone number.
     * 
     * @param phone The phone number of the user.
     * @return Optional<User> object which may or may not contain a user.
     */
    Optional<User> findByPhone(String phone);

    /**
     * Check if a user exists with the given email.
     * Useful for registration or validation checks.
     * 
     * @param email The email to check.
     * @return true if a user exists with the email, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Check if a user exists with the given phone number.
     * Useful for registration or validation checks.
     * 
     * @param phone The phone to check.
     * @return true if a user exists with the phone, false otherwise.
     */
    boolean existsByPhone(String phone);

    /**
     * Optional: Find all users with a specific role.
     * Useful for admin panels or role-based filtering.
     * 
     * @param role The role of users to find (e.g., ADMIN, DOCTOR, PATIENT)
     * @return List<User> containing all users with the specified role.
     */
    // List<User> findByRole(User.Role role); // Uncomment if needed
}

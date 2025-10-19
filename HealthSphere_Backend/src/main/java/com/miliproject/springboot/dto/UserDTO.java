package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * UserDTO is used to transfer User data safely between
 * frontend and backend, without exposing sensitive fields like passwords.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name cannot exceed 100 characters")
    private String fullName;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password; // Optional: include only when creating/updating user

    @Size(max = 15, message = "Phone number cannot exceed 15 characters")
    private String phone;

    private String role; // "ADMIN", "DOCTOR", "PATIENT"

    // Optional utility method to mask sensitive info when sending to frontend
    public void maskSensitive() {
        this.password = null;
    }
}

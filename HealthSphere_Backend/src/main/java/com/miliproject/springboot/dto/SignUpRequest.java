package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for signup requests. Supports multi-factor authentication via email/phone OTP.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestsDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    // Optional email (used for sending OTP)
    private String email;

    // Optional phone (used for sending OTP)
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    /**
     * Helper method to determine how many OTPs need to be sent (email, phone, or both)
     *
     * @return number of OTPs to send
     */
    public int otpCount() {
        int count = 0;
        if (email != null && !email.isEmpty()) count++;
        if (phone != null && !phone.isEmpty()) count++;
        return count;
    }

    /**
     * Checks if email OTP should be sent
     *
     * @return true if email is present
     */
    public boolean isEmailOtpRequired() {
        return email != null && !email.isEmpty();
    }

    /**
     * Checks if phone OTP should be sent
     *
     * @return true if phone is present
     */
    public boolean isPhoneOtpRequired() {
        return phone != null && !phone.isEmpty();
    }
}

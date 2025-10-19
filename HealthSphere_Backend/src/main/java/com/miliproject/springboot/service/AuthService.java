package com.miliproject.springboot.service;

import com.miliproject.springboot.dto.SignUpRequestsDTO;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * AuthService handles user signup, OTP generation, and saving patients to the database.
 * Uses Lombok's @RequiredArgsConstructor to inject dependencies.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    private final Random random = new Random();

    /**
     * Sends signup OTP via email and/or SMS.
     *
     * @param signUpRequest the signup request DTO containing email and phone
     */
    public void sendSignUpOtp(SignUpRequestsDTO signUpRequest) {
        if (signUpRequest.getEmail() != null && !signUpRequest.getEmail().isEmpty()) {
            sendEmailOtp(signUpRequest.getEmail());
        }
        if (signUpRequest.getPhone() != null && !signUpRequest.getPhone().isEmpty()) {
            sendSmsOtp(signUpRequest.getPhone());
        }
    }

    /**
     * Generate and send OTP to the given email.
     *
     * @param email user's email
     */
    private void sendEmailOtp(String email) {
        String otp = generateOtp();
        System.out.println("Sending OTP " + otp + " to email: " + email);
        // TODO: Integrate actual Email service
    }

    /**
     * Generate and send OTP to the given phone number.
     *
     * @param phone user's phone
     */
    private void sendSmsOtp(String phone) {
        String otp = generateOtp();
        System.out.println("Sending OTP " + otp + " to phone: " + phone);
        // TODO: Integrate actual SMS service
    }

    /**
     * Generates a 6-digit numeric OTP.
     *
     * @return OTP as String
     */
    private String generateOtp() {
        int number = 100000 + random.nextInt(900000);
        return String.valueOf(number);
    }

    /**
     * Sign up a new patient.
     * Sends OTP and saves patient in database after encoding password.
     *
     * @param signUpRequest the signup request DTO
     * @return success message
     */
    public String signUp(SignUpRequestsDTO signUpRequest) {
        // Send OTP first
        sendSignUpOtp(signUpRequest);

        // Create Patient entity
        Patient patient = Patient.builder()
                .fullName(signUpRequest.getFullName())
                .email(signUpRequest.getEmail())
                .phone(signUpRequest.getPhone())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        // Save to database
        patientRepository.save(patient);

        return "OTP sent successfully and patient registered!";
    }
}

package com.miliproject.springboot.service;

import org.springframework.stereotype.Service;
import com.miliproject.springboot.dto.SignUpRequestsDTO;
import com.miliproject.springboot.model.Patient;

@Service
public class AuthService {

    // OTP পাঠানোর method
    public void sendSignUpOtp(SignUpRequestsDTO signUpRequest) {
    	if(signUpRequest.getEmail() != null && !((String)signUpRequest.getEmail()).isEmpty()) {
    	    sendEmailOtp((String)signUpRequest.getEmail());
    	}
    	if(signUpRequest.getPhone() != null && !((String) signUpRequest.getPhone()).isEmpty()) {
    	    sendSmsOtp((String) signUpRequest.getPhone());
    	}

        }
    
    private void sendEmailOtp(String email) {
        // Email OTP পাঠানোর logic
        System.out.println("Sending OTP to email: " + email);
        // এখানে Email service যোগ করতে হবে
    }

    private void sendSmsOtp(String phone) {
        // SMS OTP পাঠানোর logic
        System.out.println("Sending OTP to phone: " + phone);
        // এখানে SMS service যোগ করতে হবে
    }

    // Signup method (entity save করার আগে OTP পাঠাতে পারি)
    public String signUp(SignUpRequestsDTO signUpRequest) {
        // OTP পাঠানো
        sendSignUpOtp(signUpRequest);

        // এখানে user save করার logic হবে (Patient/Doctor entity)
        // উদাহরণ:
        Patient patient = new Patient();
        patient.setFullName(signUpRequest.getFullName());
        // patient.setEmail(signUpRequest.getEmail());
        // patient.setPhone(signUpRequest.getPhone());
        // patient.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        // patientRepository.save(patient);

        return "OTP sent successfully!";
    }
}

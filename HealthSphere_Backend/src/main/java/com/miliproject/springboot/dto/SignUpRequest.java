package com.miliproject.springboot.dto;

import lombok.Data;

@Data
public class SignUpRequestsDTO {
    private String fullName;
    private String email;   // optional
    private String phone;   // optional
    private String password;

    // Utility method to check how many OTPs to send
    public int otpCount() {
        int count = 0;
        if(email != null && !email.isEmpty()) count++;
        if(phone != null && !phone.isEmpty()) count++;
        return count;
    }

	

	public Object getPhone() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object getFullName() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}



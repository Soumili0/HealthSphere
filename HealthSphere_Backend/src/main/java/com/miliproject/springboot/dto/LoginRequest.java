package com.miliproject.springboot.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String emailOrPhone;
    private String password;
}

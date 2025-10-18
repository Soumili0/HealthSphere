package com.miliproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.miliproject.springboot.dto.SignUpRequestsDTO;
import com.miliproject.springboot.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequestsDTO signUpRequest) {
        return authService.signUp(signUpRequest);
    }
}

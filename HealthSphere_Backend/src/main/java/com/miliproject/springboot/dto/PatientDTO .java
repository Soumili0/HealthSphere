package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;
    private String fullName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String medicalHistory;
}

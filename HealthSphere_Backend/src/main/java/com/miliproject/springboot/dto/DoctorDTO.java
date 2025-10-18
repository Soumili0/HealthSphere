package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Long id;
    private String fullName;
    private String specialization;
    private String email;
    private String phone;
    private String address;
    private String qualification;
    private int experience;
}

package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Doctor entity.
 * Used to transfer only necessary doctor data between layers or APIs.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    /**
     * Doctor ID
     */
    private Long id;

    /**
     * Full name of the doctor
     */
    private String fullName;

    /**
     * Specialization of the doctor (e.g., Cardiologist, Dermatologist)
     */
    private String specialization;

    /**
     * Email of the doctor
     */
    private String email;

    /**
     * Phone number of the doctor
     */
    private String phone;

    /**
     * Address of the doctor
     */
    private String address;

    /**
     * Qualification of the doctor (e.g., MBBS, MD)
     */
    private String qualification;

    /**
     * Years of experience
     */
    private int experience;
}

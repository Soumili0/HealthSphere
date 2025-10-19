package com.miliproject.springboot.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object representing an Electronic Health Record (EHR)
 * Combines Patient, Doctor, Appointment, and Prescription details for API responses
 */
@Data
public class EHRDTO {

    // =========================
    // Patient information
    // =========================
    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String patientPhone;

    // =========================
    // Doctor information
    // =========================
    private Long doctorId;
    private String doctorName;
    private String doctorSpecialization;

    // =========================
    // Appointment information
    // =========================
    private LocalDateTime appointmentDate;
    private String appointmentStatus; // scheduled, completed, canceled

    // =========================
    // Prescription information
    // =========================
    private String diagnosis;
    private List<String> medications; // ["Drug A 5mg", "Drug B 10mg"]
    private LocalDate prescriptionDate;
    private String notes; // Extra notes or observations
}

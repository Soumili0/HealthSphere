package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDateTime;

    private String status;  // e.g. Scheduled, Completed, Cancelled

    // Many appointments belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Many appointments belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}

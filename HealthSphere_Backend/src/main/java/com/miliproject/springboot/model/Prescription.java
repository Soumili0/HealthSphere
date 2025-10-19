package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String diagnosis;

    @Column(nullable = false)
    private String medications;

    private String notes;

    private LocalDate date;

    // =========================
    // 🔗 Relationships
    // =========================

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // Automatically set date when saving new prescription
    @PrePersist
    public void prePersist() {
        if (date == null) {
            date = LocalDate.now();
        }
    }
}

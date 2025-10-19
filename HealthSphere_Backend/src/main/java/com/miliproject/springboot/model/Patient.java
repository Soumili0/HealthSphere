package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ehr_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EHRRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // 🔗 Relationships
    // =========================

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // =========================
    // 🔹 Record Details
    // =========================

    @Column(nullable = false)
    private String diagnosis;

    private String treatmentDetails;

    private String testResults;

    private String notes;

    @Column(nullable = false)
    private LocalDate recordDate;

    // Automatically set recordDate when saving new record
    @PrePersist
    public void prePersist() {
        if (recordDate == null) {
            recordDate = LocalDate.now();
        }
    }
}

package com.miliproject.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    // The patient this record belongs to
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull
    private Patient patient;

    // The doctor who created this record
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull
    private Doctor doctor;

    // Information about the diagnosis
    @Column(nullable = false)
    @NotBlank
    private String diagnosis;

    // Details about treatment or prescription
    @Lob
    private String treatmentDetails;

    // Results of medical tests
    @Lob
    private String testResults;

    // Additional notes
    @Lob
    private String notes;

    // Date of the record
    private LocalDate recordDate = LocalDate.now();
}

package com.miliproject.springboot.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PrescriptionDTO {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String diagnosis;
    private String medications; // e.g., "Drug A 5mg, Drug B 10mg"
    private LocalDate date;
}

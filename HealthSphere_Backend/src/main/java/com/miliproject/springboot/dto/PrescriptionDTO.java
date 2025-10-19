package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private Long id;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private String diagnosis;

    @NotEmpty
    private List<String> medications; // ["Drug A 5mg", "Drug B 10mg"]

    private LocalDate date;

    private String notes; // Optional extra notes
}

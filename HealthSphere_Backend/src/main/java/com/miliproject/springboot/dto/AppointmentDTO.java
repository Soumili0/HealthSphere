package com.miliproject.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for Appointment entity.
 * Used to transfer only necessary appointment data between layers or APIs.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    /**
     * Appointment ID
     */
    private Long id;

    /**
     * ID of the patient for this appointment
     */
    private Long patientId;

    /**
     * ID of the doctor for this appointment
     */
    private Long doctorId;

    /**
     * Scheduled date and time for the appointment
     */
    private LocalDateTime appointmentDate;

    /**
     * Status of the appointment
     * Possible values: "SCHEDULED", "COMPLETED", "CANCELLED"
     */
    private String status;
}

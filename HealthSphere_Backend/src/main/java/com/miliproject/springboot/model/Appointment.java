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

    // Future mapping: Doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

	public Object getAppointmentDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getDoctorId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Doctor getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}

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

    // Prescription কে patient এর সাথে link
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Prescription কে doctor এর সাথে link
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

	public Doctor getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDiagnosis() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMedications() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

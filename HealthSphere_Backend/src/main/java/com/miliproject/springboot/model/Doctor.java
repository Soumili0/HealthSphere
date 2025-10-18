package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String specialization;   // e.g. Cardiologist, Dermatologist

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;

    private String qualification;   // e.g. MBBS, MD

    private int experience;         // in years

    // ======================
    // 🔗 Relationship Mapping
    // ======================

    // One doctor can have many appointments
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSpecialization() {
		// TODO Auto-generated method stub
		return null;
	}
}

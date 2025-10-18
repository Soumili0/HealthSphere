package com.miliproject.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique ID for each patient

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private int age;

    @Column(length = 10)
    private String gender;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;

    @Column(length = 500)
    private String medicalHistory;  // Optional: short medical background


    // ======================
    // 🔗 Relationship Mapping
    // ======================

    // One Patient can have multiple Appointments
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;


	public void setFullName(Object fullName2) {
		// TODO Auto-generated method stub
		
	}


	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getFullName() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

}

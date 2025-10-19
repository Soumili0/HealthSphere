package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    // ================================
    // 🔹 Find all prescriptions for a specific Patient object
    // ================================
    List<Prescription> findByPatient(Patient patient);

    // ================================
    // 🔹 Find all prescriptions for a specific Doctor object
    // ================================
    List<Prescription> findByDoctor(Doctor doctor);

    // ================================
    // 🔹 Find all prescriptions by patient ID
    // Useful if you have the ID instead of the Patient object
    // ================================
    List<Prescription> findByPatientId(Long patientId);
}

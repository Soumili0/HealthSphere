package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    // Patient object অনুযায়ী prescription গুলি
    List<Prescription> findByPatient(Patient patient);

    // Doctor object অনুযায়ী prescription গুলি
    List<Prescription> findByDoctor(Doctor doctor);

    // ✅ FIX: Add this method to resolve the 'findByPatientId' error
    List<Prescription> findByPatientId(Long patientId);
}

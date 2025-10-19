package com.miliproject.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miliproject.springboot.model.Patient;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // ================================
    // 🔹 Find a patient by their email
    // ================================
    // Returns an Optional<Patient> because the patient may or may not exist
    Optional<Patient> findByEmail(String email);

    // ================================
    // 🔹 Find a patient by their phone number
    // ================================
    // Returns an Optional<Patient> for the same reason as above
    Optional<Patient> findByPhone(String phone);
}

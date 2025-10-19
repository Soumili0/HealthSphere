package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to handle Patient-related operations.
 */
@Service
@RequiredArgsConstructor // Lombok generates constructor for all final fields
public class PatientService {

    private final PatientRepository patientRepository;

    /**
     * Fetch all patients from the database.
     *
     * @return list of all patients
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Fetch a patient by their ID.
     *
     * @param id Patient ID
     * @return Optional containing patient if found
     */
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    /**
     * Fetch a patient by their email.
     *
     * @param email Patient email
     * @return Optional containing patient if found
     */
    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    /**
     * Fetch a patient by their phone number.
     *
     * @param phone Patient phone
     * @return Optional containing patient if found
     */
    public Optional<Patient> getPatientByPhone(String phone) {
        return patientRepository.findByPhone(phone);
    }

    /**
     * Add a new patient.
     * Validates that email and phone are unique.
     *
     * @param patient Patient entity to save
     * @return Saved patient entity
     */
    public Patient addPatient(Patient patient) {
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + patient.getEmail());
        }
        if (patientRepository.findByPhone(patient.getPhone()).isPresent()) {
            throw new RuntimeException("Phone already exists: " + patient.getPhone());
        }
        return patientRepository.save(patient);
    }

    /**
     * Update an existing patient by ID.
     *
     * @param id             Patient ID
     * @param updatedPatient Patient entity with updated data
     * @return Updated patient entity
     */
    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id).map(patient -> {
            patient.setFullName(updatedPatient.getFullName());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setAddress(updatedPatient.getAddress());
            patient.setEmail(updatedPatient.getEmail());
            patient.setPhone(updatedPatient.getPhone());
            return patientRepository.save(patient);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    /**
     * Delete a patient by ID.
     *
     * @param id Patient ID to delete
     */
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}

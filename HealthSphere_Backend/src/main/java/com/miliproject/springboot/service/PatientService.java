package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Get patient by email
    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    // Get patient by phone
    public Optional<Patient> getPatientByPhone(String phone) {
        return patientRepository.findByPhone(phone);
    }

    // Add new patient
    public Patient addPatient(Patient patient) {
        // Optional: check if email or phone already exists
        if (patientRepository.findByEmail((String) patient.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + patient.getEmail());
        }
        if (patientRepository.findByPhone((String) patient.getPhone()).isPresent()) {
            throw new RuntimeException("Phone already exists: " + patient.getPhone());
        }
        return patientRepository.save(patient);
    }

    // Update existing patient
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

    // Delete patient
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }
}

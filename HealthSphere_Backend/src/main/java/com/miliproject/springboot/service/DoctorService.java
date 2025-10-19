package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Doctor;
import com.miliproject.springboot.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DoctorService handles all business logic related to Doctor entities.
 */
@Service
@RequiredArgsConstructor  // Lombok generates constructor for final fields
public class DoctorService {

    private final DoctorRepository doctorRepository;

    /**
     * Save a new doctor or update an existing one.
     *
     * @param doctor the Doctor entity to save
     * @return saved Doctor entity
     */
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Retrieve all doctors from the database.
     *
     * @return list of all Doctor entities
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Find a doctor by its ID.
     *
     * @param id the Doctor ID
     * @return Doctor entity
     * @throws RuntimeException if doctor is not found
     */
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }
}

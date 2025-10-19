package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling Prescription-related operations.
 */
@Service
@RequiredArgsConstructor // Lombok generates constructor for all final fields
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    /**
     * Fetch all prescriptions from the database.
     *
     * @return list of all prescriptions
     */
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    /**
     * Fetch a prescription by its ID.
     *
     * @param id Prescription ID
     * @return Optional containing prescription if found
     */
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    /**
     * Add a new prescription.
     *
     * @param prescription Prescription entity to save
     * @return Saved prescription entity
     */
    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    /**
     * Update an existing prescription by ID.
     *
     * @param id                  Prescription ID
     * @param updatedPrescription Updated prescription data
     * @return Updated prescription entity
     * @throws RuntimeException if prescription with given ID not found
     */
    public Prescription updatePrescription(Long id, Prescription updatedPrescription) {
        return prescriptionRepository.findById(id)
                .map(prescription -> {
                    prescription.setPatient(updatedPrescription.getPatient());
                    prescription.setDoctor(updatedPrescription.getDoctor());
                    prescription.setDiagnosis(updatedPrescription.getDiagnosis());
                    prescription.setMedications(updatedPrescription.getMedications());
                    prescription.setNotes(updatedPrescription.getNotes());
                    prescription.setDate(updatedPrescription.getDate());
                    return prescriptionRepository.save(prescription);
                })
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }

    /**
     * Delete a prescription by ID.
     *
     * @param id Prescription ID to delete
     * @throws RuntimeException if prescription with given ID not found
     */
    public void deletePrescription(Long id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found with id: " + id);
        }
        prescriptionRepository.deleteById(id);
    }
}

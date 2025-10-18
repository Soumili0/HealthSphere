package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresciptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PresciptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public Prescription updatePrescription(Long id, Prescription updatedPrescription) {
        return prescriptionRepository.findById(id).map(prescription -> {
            prescription.setPatient(updatedPrescription.getPatient());
            prescription.setDoctor(updatedPrescription.getDoctor());
            prescription.setMedications(updatedPrescription.getMedications());
            prescription.setNotes(updatedPrescription.getNotes());
            return prescriptionRepository.save(prescription);
        }).orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }

    public void deletePrescription(Long id) {
        if (!prescriptionRepository.existsById(id)) {
            throw new RuntimeException("Prescription not found with id: " + id);
        }
        prescriptionRepository.deleteById(id);
    }
}

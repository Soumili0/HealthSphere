  package com.miliproject.springboot.service;

import com.miliproject.springboot.dto.EHRDTO;
import com.miliproject.springboot.model.Appointment;
import com.miliproject.springboot.model.Doctor;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.repository.AppointmentRepository;
import com.miliproject.springboot.repository.DoctorRepository;
import com.miliproject.springboot.repository.PatientRepository;
import com.miliproject.springboot.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to handle EHR (Electronic Health Records) operations.
 */
@Service
@RequiredArgsConstructor  // Lombok generates constructor for all final fields
public class EHRService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PrescriptionRepository prescriptionRepository;

    /**
     * Fetch all EHR records for a given patient.
     *
     * @param patientId the ID of the patient
     * @return List of EHRDTO containing patient, doctor, appointment, and prescription info
     */
    @Transactional
    public List<EHRDTO> getPatientEHR(Long patientId) {
        // Fetch patient entity
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

        // Fetch all appointments and prescriptions for the patient
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);

        // Map appointments to EHRDTO
        return appointments.stream().map(appointment -> {
            EHRDTO ehr = new EHRDTO();

            Doctor doctor = appointment.getDoctor();
            if (doctor == null) {
                throw new RuntimeException("Doctor missing for appointment ID: " + appointment.getId());
            }

            // Set patient info
            ehr.setPatientId(patient.getId());
            ehr.setPatientName(patient.getFullName());
            ehr.setPatientEmail(patient.getEmail());
            ehr.setPatientPhone(patient.getPhone());

            // Set doctor info
            ehr.setDoctorId(doctor.getId());
            ehr.setDoctorName(doctor.getFullName());
            ehr.setDoctorSpecialization(doctor.getSpecialization());

            // Set appointment info
            ehr.setAppointmentDate(appointment.getAppointmentDate());
            ehr.setAppointmentStatus(appointment.getStatus());

            // Set prescription info if exists
            prescriptions.stream()
                    .filter(p -> p.getDoctor().getId().equals(doctor.getId()))
                    .findFirst()
                    .ifPresent(p -> {
                        ehr.setDiagnosis(p.getDiagnosis());
                        ehr.setMedications(Arrays.asList(p.getMedications().split("\\s*,\\s*")));
                        ehr.setPrescriptionDate(p.getDate());
                        ehr.setNotes(p.getNotes());
                    });

            return ehr;
        }).collect(Collectors.toList());
    }
}

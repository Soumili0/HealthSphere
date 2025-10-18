package com.miliproject.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional; // Added for safety against LazyInitializationException

import com.miliproject.springboot.dto.EHRDTO;
import com.miliproject.springboot.model.Appointment;
import com.miliproject.springboot.model.Doctor;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.model.Prescription;
import com.miliproject.springboot.repository.PatientRepository;
import com.miliproject.springboot.repository.DoctorRepository;
import com.miliproject.springboot.repository.AppointmentRepository;
import com.miliproject.springboot.repository.PrescriptionRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Service
public class EHRService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    /**
     * Fetches all EHR records for a patient.
     */
    @Transactional // Use Transactional to ensure lazy-loaded relationships are accessible
    public List<EHRDTO> getPatientEHR(Long patientId) {
        // Patient fetch
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Fetch all appointments for the patient
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);

        // Fetch all prescriptions once for the patient
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);

        // Map each appointment to an EHRDTO
        List<EHRDTO> ehrList = appointments.stream().map(appointment -> {
            EHRDTO ehr = new EHRDTO();

            // ✅ FIX for Line 61 Error (and N+1 performance issue): 
            // Get the Doctor object directly from the appointment.
            Doctor doctor = appointment.getDoctor(); 

            // Handle mandatory Doctor check (if doctor is null, something is wrong)
            if (doctor == null) {
                 throw new RuntimeException("Doctor data is missing for appointment ID: " + appointment.getId());
            }

            // Patient info
            ehr.setPatientId(patient.getId());
            ehr.setPatientName(patient.getFullName());
            ehr.setPatientEmail(patient.getEmail());
            ehr.setPatientPhone(patient.getPhone());

            // Doctor info
            ehr.setDoctorId(doctor.getId());
            // Accessing properties of the Doctor object fetched from the appointment
            ehr.setDoctorName(doctor.getFullName());
            ehr.setDoctorSpecialization(doctor.getSpecialization());

            // Appointment info
            ehr.setAppointmentDate(appointment.getAppointmentDate());
            ehr.setAppointmentStatus(appointment.getStatus());

            // Prescription info: match prescriptions for this patient & doctor
            prescriptions.stream()
                    // ✅ CORRECTION: Use p.getDoctor().getId()
                    .filter(p -> p.getDoctor().getId().equals(doctor.getId())) 
                    .findFirst()
                    .ifPresent(p -> {
                        ehr.setDiagnosis(p.getDiagnosis());
                        
                        // ✅ CORRECTION: Split the comma-separated String into a List<String>
                        List<String> meds = Arrays.asList(p.getMedications().split("\\s*,\\s*"));
                        ehr.setMedications(meds);
                        
                        ehr.setPrescriptionDate(p.getDate());
                        ehr.setNotes(p.getNotes());
                    });

            return ehr;
        }).collect(Collectors.toList());

        return ehrList;
    }
}

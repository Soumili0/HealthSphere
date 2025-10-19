package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Appointment;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.AppointmentRepository;
import com.miliproject.springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for handling Appointments and Patients.
 */
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Save a new appointment
     *
     * @param appointment Appointment entity
     * @return saved Appointment
     */
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * Get all appointments
     *
     * @return list of all appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    /**
     * Get appointments for a specific patient
     *
     * @param patientId patient id
     * @return list of appointments for the patient
     */
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    /**
     * Get appointments for a specific doctor
     *
     * @param doctorId doctor id
     * @return list of appointments for the doctor
     */
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctor_Id(doctorId);
    }

    // ================================
    // Patient-related methods
    // ================================

    /**
     * Save a new patient
     *
     * @param patient Patient entity
     * @return saved Patient
     */
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * Get all patients
     *
     * @return list of all patients
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Get a patient by ID
     *
     * @param id patient id
     * @return patient if found, else null
     */
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }
}

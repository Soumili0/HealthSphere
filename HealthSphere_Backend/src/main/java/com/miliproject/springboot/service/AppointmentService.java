package com.miliproject.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.miliproject.springboot.model.Appointment;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        // ✅ FIX: Repository-এর নতুন মেথড call করা
        return appointmentRepository.findByDoctor_Id(doctorId); 
    }

	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient getPatientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

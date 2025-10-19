package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    // Find all appointments for a given patient ID
    List<Appointment> findByPatientId(Long patientId);

    // Find all appointments for a given doctor ID
    // Explanation:
    // - 'Doctor' is the field name in Appointment entity
    // - '_Id' means we're querying the 'id' of the associated Doctor entity
    List<Appointment> findByDoctor_Id(Long doctorId);
}

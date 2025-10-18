package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    // Patient object এর ID অনুযায়ী Appointment খোঁজা
    List<Appointment> findByPatientId(Long patientId);

    // ✅ FIX: Doctor object এর ID অনুযায়ী Appointment খোঁজা
    // 'Doctor' (field) -> '_' -> 'Id' (primary key)
    List<Appointment> findByDoctor_Id(Long doctorId);
}

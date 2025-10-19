package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.Videocall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * VideocallRepository provides database operations for the Videocall entity.
 * It extends JpaRepository to inherit CRUD methods like save(), findById(), delete(), etc.
 */
@Repository
public interface VideocallRepository extends JpaRepository<Videocall, Long> {

    /**
     * Fetch all video calls scheduled for a specific patient.
     *
     * @param patientId the ID of the patient
     * @return list of Videocall objects for the patient
     */
    List<Videocall> findByPatientId(Long patientId);

    /**
     * Fetch all video calls scheduled for a specific doctor.
     *
     * @param doctorId the ID of the doctor
     * @return list of Videocall objects for the doctor
     */
    List<Videocall> findByDoctorId(Long doctorId);
}

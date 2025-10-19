package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.EHRRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EHRRepository extends JpaRepository<EHRRecord, Long> {

    // ================================
    // 🔹 Fetch all EHR records for a specific patient
    // ================================
    // This method generates a query like:
    // SELECT * FROM ehr_records WHERE patient_id = :patientId
    List<EHRRecord> findByPatientId(Long patientId);

    // ================================
    // 🔹 Fetch all EHR records created by a specific doctor
    // ================================
    // This method generates a query like:
    // SELECT * FROM ehr_records WHERE doctor_id = :doctorId
    List<EHRRecord> findByDoctorId(Long doctorId);
}

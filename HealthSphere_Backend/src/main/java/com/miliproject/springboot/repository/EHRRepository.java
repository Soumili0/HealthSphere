package com.miliproject.springboot.repository;

import com.miliproject.springboot.model.EHRRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EHRRepository extends JpaRepository<EHRRecord, Long> {

    // নির্দিষ্ট রোগীর সব EHR রেকর্ড
    List<EHRRecord> findByPatientId(Long patientId);

    // নির্দিষ্ট ডাক্তারের সব রেকর্ড
    List<EHRRecord> findByDoctorId(Long doctorId);
}

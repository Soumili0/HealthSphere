package com.miliproject.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class VideocallRepository {

	public interface VideoCallRepository extends JpaRepository<VideocallRepository, Long> {
	    List<VideocallRepository> findByPatientId(Long patientId);
	    List<VideocallRepository> findByDoctorId(Long doctorId);
	}

}

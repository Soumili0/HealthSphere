package com.miliproject.springboot.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "video_calls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videocall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private LocalDateTime scheduledAt;

    private String callLink; // Zoom / Jitsi / custom link

    private String status; // Scheduled, Completed, Cancelled

	public Object getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDoctor(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	public void setStartTime(LocalDateTime startTime) {
		// TODO Auto-generated method stub
		
	}

	public void setEndTime(LocalDateTime endTime) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(String status2) {
		// TODO Auto-generated method stub
		
	}
}

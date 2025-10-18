package com.miliproject.springboot.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EHRDTO {

    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String patientPhone;

    private Long doctorId;
    private String doctorName;
    private String doctorSpecialization;

    private LocalDateTime appointmentDate;
    private String appointmentStatus; // scheduled, completed, canceled

    private String diagnosis;
    private List<String> medications; // ["Drug A 5mg", "Drug B 10mg"]
    private LocalDate prescriptionDate;

    private String notes; // Extra notes or observations

	public void setAppointmentDate(Object appointmentDate2) {
		// TODO Auto-generated method stub
		
	}

	public void setPatientId(Object id) {
		// TODO Auto-generated method stub
		
	}

	public void setPatientName(Object fullName) {
		// TODO Auto-generated method stub
		
	}

	public void setPatientEmail(Object email) {
		// TODO Auto-generated method stub
		
	}

	public void setPatientPhone(Object phone) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctorId(Object id) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctorName(Object fullName) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctorSpecialization(Object specialization) {
		// TODO Auto-generated method stub
		
	}

	public void setDiagnosis(Object diagnosis2) {
		// TODO Auto-generated method stub
		
	}

	public void setMedications(List<String> meds) {
		// TODO Auto-generated method stub
		
	}

	public void setAppointmentStatus(Object status) {
		// TODO Auto-generated method stub
		
	}

	public void setPrescriptionDate(Object date) {
		// TODO Auto-generated method stub
		
	}

	public void setNotes(Object notes2) {
		// TODO Auto-generated method stub
		
	}

	

}

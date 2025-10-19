package com.miliproject.springboot.service;

import com.miliproject.springboot.model.Videocall;
import com.miliproject.springboot.model.Doctor;
import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.repository.VideocallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

/**
 * Service class to handle all video call operations
 */
@Service
@RequiredArgsConstructor
public class VideocallService {

    private final VideocallRepository videoCallRepository;

    /**
     * Fetch all video calls
     * @return list of all Videocall objects
     */
    public List<Videocall> getAllCalls() {
        return videoCallRepository.findAll();
    }

    /**
     * Fetch a specific video call by its ID
     * @param id the Videocall ID
     * @return optional Videocall object
     */
    public Optional<Videocall> getCallById(Long id) {
        return videoCallRepository.findById(id);
    }

    /**
     * Schedule a new video call
     * @param call Videocall object containing patient, doctor, date/time info
     * @return saved Videocall object
     */
    public Videocall scheduleCall(Videocall call) {
        return videoCallRepository.save(call);
    }

    /**
     * Update an existing video call
     * @param id ID of the Videocall to update
     * @param updatedCall Videocall object containing updated info
     * @return updated Videocall object
     */
    public Videocall updateCall(Long id, Videocall updatedCall) {
        return videoCallRepository.findById(id)
                .map(call -> {
                    call.setDoctor(updatedCall.getDoctor());
                    call.setPatient(updatedCall.getPatient());
                    call.setScheduledAt(updatedCall.getScheduledAt());
                    call.setCallLink(updatedCall.getCallLink());
                    call.setStatus(updatedCall.getStatus());
                    return videoCallRepository.save(call);
                })
                .orElseThrow(() -> new RuntimeException("Video call not found with id: " + id));
    }

    /**
     * Cancel a video call by ID
     * @param id ID of the Videocall to cancel
     */
    public void cancelCall(Long id) {
        if (!videoCallRepository.existsById(id)) {
            throw new RuntimeException("Video call not found with id: " + id);
        }
        videoCallRepository.deleteById(id);
    }

    /**
     * Fetch all calls for a specific patient
     * @param patientId ID of the patient
     * @return list of Videocall objects
     */
    public List<Videocall> getCallsByPatient(Long patientId) {
        return videoCallRepository.findByPatientId(patientId);
    }

    /**
     * Fetch all calls for a specific doctor
     * @param doctorId ID of the doctor
     * @return list of Videocall objects
     */
    public List<Videocall> getCallsByDoctor(Long doctorId) {
        return videoCallRepository.findByDoctorId(doctorId);
    }
}
